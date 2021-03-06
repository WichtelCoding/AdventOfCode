import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class RecursiveCircus {

    public static void main(String[] args) throws FileNotFoundException {
	Scanner sc = new Scanner(new FileReader(".\\Day-7\\day7.in"));
	HashSet<String> hsName = new HashSet<String>();
	HashMap<String, List<String>> hmTree = new HashMap<String, List<String>>();
	while (sc.hasNextLine()) {
	    String[] row = sc.nextLine().split(" -> ");
	    String name = row[0].substring(0, row[0].indexOf(" "));
	    hsName.add(name);
	    List<String> list = hmTree.computeIfAbsent(name,
		    a -> new ArrayList<>());
	    if (row.length == 2) {
		list.addAll(Arrays.asList(row[1].split(", ")));
	    }

	}
	List<String> roots = new ArrayList<>(hmTree.keySet());
	hmTree.values().forEach(roots::removeAll);
	String root = roots.get(0);
	System.out.println(root);
	sc.close();
    }

}

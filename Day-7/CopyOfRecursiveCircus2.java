import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CopyOfRecursiveCircus2 {
    
    static HashMap<String, Integer> hmName = new HashMap<String, Integer>();
    static HashMap<String, List<String>> hmTree = new HashMap<String, List<String>>();
    
    public static void main(String[] args) throws FileNotFoundException {
	Scanner sc = new Scanner(new FileReader(".\\Day-7\\day7.in"));
	while (sc.hasNextLine()) {
	    String[] row = sc.nextLine().split(" -> ");
	    String name = row[0].substring(0, row[0].indexOf(" "));
	    String weight = row[0].substring(row[0].indexOf("(")  + 1, row[0].length() - 1);
	    hmName.put(name, Integer.parseInt(weight));
	    List<String> list = hmTree.computeIfAbsent(name,
						       a -> new ArrayList<String>());
	    if (row.length == 2) {
		list.addAll(Arrays.asList(row[1].split(", ")));
	    }
	    
	}
	List<String> roots = new ArrayList<String>(hmTree.keySet());
	hmTree.values().forEach(roots::removeAll);
	String root = roots.get(0);
	weight(root);
	for(String child: hmTree.get("idfyy"))
	    System.out.println(child + sum(weight(child)));
	System.out.println(hmName.get("aobgmc")-8);
	sc.close();
    }
    
    public static int[] weight(String root){
	if(hmTree.get(root).size() == 0)
	    return new int[]{ hmName.get(root) };
	int[] ws = new int[hmTree.get(root).size() + 1];
	ws[0] = hmName.get(root);
	for(int i = 1; i < ws.length; ++i){
	    ws[i] = sum(weight(hmTree.get(root).get(i-1)));
	}
	for(int i = 2; i < ws.length; ++i){
	    if(ws[i] != ws[i-1]) {
		System.out.println(root);
		for(int j = 1; j < ws.length; ++j)
		    System.out.print(" " + ws[j]);
		System.out.println();
	    }
	}
	return ws;
    }

    public static int sum(int[] a){
	int s = 0;
	for(int i = 0; i < a.length; ++i)
	    s += a[i];
	return s;
    }
}
	

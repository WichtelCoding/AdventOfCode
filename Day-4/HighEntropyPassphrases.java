import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class HighEntropyPassphrases {

    public static void main(String[] args) throws FileNotFoundException {
	Scanner sc = new Scanner(new FileReader(".\\Day-4\\day4.in"));
	int validPw = 0;
	while (sc.hasNextLine()) {
	    HashSet<String> hs = new HashSet<String>();
	    String[] row = sc.nextLine().split(" ");
	    boolean valid = true;
	    for (int i = 0; i < row.length; ++i) {
		if (hs.contains(row[i])) {
		    valid = false;
		}
		else {
		    hs.add(row[i]);
		}
	    }
	    if (valid) {
		validPw++;
	    }
	}
	System.out.println(validPw);
	sc.close();
    }

}

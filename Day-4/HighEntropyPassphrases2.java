import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class HighEntropyPassphrases2 {

    public static void main(String[] args) throws FileNotFoundException {
	Scanner sc = new Scanner(new FileReader(".\\Day-4\\day4.in"));
	int validPw = 0;
	while (sc.hasNextLine()) {
	    HashSet<String> hs = new HashSet<String>();
	    String[] row = sc.nextLine().split(" ");
	    boolean valid = true;
	    for (int i = 0; i < row.length; ++i) {
		if (hs.contains(encode(row[i]))) {
		    valid = false;
		}
		else {
		    hs.add(encode(row[i]));
		}
	    }
	    if (valid) {
		validPw++;
	    }
	}
	System.out.println(validPw);
	sc.close();
    }

    public static String encode(String s) {
	char[] c = s.toCharArray();
	Arrays.sort(c);
	int i = 0;
	String out = "";
	char last = c[0];
	while (i < c.length) {
	    int cnt = 0;
	    while (i < c.length && c[i] == last) {
		++cnt;
		++i;
	    }
	    out += new Character(last).toString() + new Integer(cnt).toString();
	    if (i < c.length)
		last = c[i];
	}
	return out;
    }
}

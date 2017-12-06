import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class MemoryReallocation {

    public static void main(String[] args) throws FileNotFoundException {
	Scanner sc = new Scanner(new FileReader(".\\Day-6\\day6.in"));

	HashMap<String, Integer> hs = new HashMap<String, Integer>();
	String[] row = sc.nextLine().split("\t");
	int[] mem = new int[row.length];
	for (int i = 0; i < mem.length; ++i) {
	    mem[i] = Integer.parseInt(row[i]);
	}
	int res = 0;
	while (!hs.containsKey(toString(mem))) {
	    hs.put(toString(mem), res);
	    mem = nextMEM(mem);
	    res++;
	}
	System.out.println(res - hs.get(toString(mem)));
	sc.close();
    }

    public static String toString(int[] mem) {
	String s = "";

	for (int i = 0; i < mem.length; ++i) {
	    s += new Integer(mem[i]).toString() + " ";
	}
	return s;
    }

    public static int[] nextMEM(int[] mem) {
	int max = 0;
	int index = 0;
	for (int i = 0; i < mem.length; ++i) {
	    if (mem[i] > max) {
		max = mem[i];
		index = i;
	    }
	}
	mem[index] = 0;
	index++;
	for (int i = 0; i < max; ++i) {
	    mem[index % mem.length]++;
	    index++;
	}
	return mem;
    }
}

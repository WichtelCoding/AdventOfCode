import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class AMazeofTwistyTrampolinesAllAlike {

    public static void main(String[] args) throws FileNotFoundException {
	Scanner sc = new Scanner(new FileReader(".\\Day-5\\day5.in"));

	int[] instr = new int[1066];
	for (int i = 0; i < instr.length; ++i) {
	    instr[i] = sc.nextInt();
	}

	int step = 0;
	int i = 0;
	while (i > -1 && i < instr.length) {
	    int tmp = instr[i];

	    if (tmp < 3) {
		++instr[i];
	    }
	    else {
		--instr[i];
	    }
	    i += tmp;
	    step++;
	}
	System.out.println(step);
	sc.close();
    }
}

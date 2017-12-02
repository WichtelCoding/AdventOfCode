import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;


public class CorruptionChecksum {

    public static void main(String[] args) throws FileNotFoundException {
	Scanner sc = new Scanner(new FileReader(".\\Day-2\\day2.in"));
	
	int sum = 0;
	
	while(sc.hasNextLine()){
	    String[] row = sc.nextLine().split("\t");
	    int[] vals = new int[row.length];
	    for(int i = 0; i < row.length; ++i){
		vals[i] = Integer.parseInt(row[i]);
	    }
	    Arrays.sort(vals);
	    for(int i = 0; i < vals.length; ++i){
		for(int j = i+1; j < vals.length; ++j){
		    if(vals[j] % vals[i] == 0){
			sum += vals[j] / vals[i];
		    }
		}
	    }
	}
	System.out.println(sum);
	sc.close();
    }

}

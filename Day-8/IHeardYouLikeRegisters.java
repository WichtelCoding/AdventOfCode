import java.util.*;
import java.lang.*;

public class IHeardYouLikeRegisters {
    
    static HashMap<String, Integer> reg = new HashMap<String, Integer>();
    
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int m = 0;
	while(sc.hasNextLine()){
	    String[] in = sc.nextLine().split(" ");
	    if(!reg.containsKey(in[0]))
		reg.put(in[0], 0);
	    if(!reg.containsKey(in[4]))
		reg.put(in[4], 0);
	    if(compare(in[4], in[5], Integer.parseInt(in[6])))
		if(in[1].equals("inc")) {
		    int tmp = reg.get(in[0]) + Integer.parseInt(in[2]);
		    reg.put(in[0], tmp);
		    if(tmp > m)
			m = tmp;
		} else {
		    int tmp = reg.get(in[0]) - Integer.parseInt(in[2]);
		    reg.put(in[0], tmp);
		    if(tmp > m)
			m = tmp;
		}
		       
			       
	}
	int max = Integer.MIN_VALUE;
	for(String s : reg.keySet())
	    if(reg.get(s) > max)
		max = reg.get(s);
	System.out.println(max);
	System.out.println(m);
	sc.close();
    }

    public static boolean compare(String a, String b, int c){
	if(b.equals(">"))
	    return reg.get(a) > c;
	if(b.equals("<"))
	    return reg.get(a) < c;
	if(b.equals(">="))
	    return reg.get(a) >= c;
	if(b.equals("<="))
	    return reg.get(a) <= c;
	if(b.equals("=="))
	    return reg.get(a) == c;
	return reg.get(a) != c;
    }
}

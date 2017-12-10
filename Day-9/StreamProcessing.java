import java.lang.*;
import java.util.*;

public class StreamProcessing {
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Stack<Character> stack = new Stack<Character>();
	String in = sc.nextLine();
	List<Character> list = new ArrayList<Character>();
	for(int i = 0; i < in.length(); ++i){
	    if(in.charAt(i) == '!'){
		i++;
		continue;
	    }
	    list.add(in.charAt(i));
	}
	
	int sum = 0;
	int garbage = 0;
	
	for(int i = 0; i < list.size(); ++i){
	    char c = list.get(i);
	    if(!stack.isEmpty() && stack.peek() == '<' && c != '>'){
		garbage++;
		continue;
	    }
	    else if(c == '{'){
		stack.push(c);
		sum += stack.size();
	    }
	    else if(c == '<'){
		stack.push(c);
	    }
	    else if (c == '}' || c == '>'){
		stack.pop();
	    }
	}
	System.out.println(sum);
	System.out.println(garbage);
	
	sc.close();
    }
}

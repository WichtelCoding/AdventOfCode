import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringWriter;

public class InverseCaptcha {

    public static void main(String[] args) {
	String input = readText();
	int sum = 0;
	for(int i = 0; i < input.length(); ++i){
	    if(input.charAt(i) == input.charAt((i + input.length()/2) % input.length())){
		sum += input.charAt(i) - 48;
	    }
	}
	System.out.println(sum);
    }

    @SuppressWarnings("resource")
    public static String readText() {
	BufferedReader br;
	StringWriter sw = new StringWriter();
	try {
		br = new BufferedReader(new FileReader(
				".\\Day-1\\day1-2.in"));
		String s = null;
		while ((s = br.readLine()) != null) {
			sw.append(s);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return sw.toString();
}
}

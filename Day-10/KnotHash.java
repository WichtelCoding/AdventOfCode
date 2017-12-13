import java.util.*;

public class KnotHash {
    
    public static int[] list = new int[256];
    
    public static void main(String[] args) {
	int[] input = new int[]{227,169,3,166,246,201,0,47,1,255,2,254,96,3,97,144};
	int pointer = 0;
	int skip = 0;
	
	for(int i = 0; i < 256; ++i)
	    list[i] = i;
	for(int i = 0; i < input.length; ++i){
	    reverse(pointer, input[i]);
	    pointer += skip + input[i];
	}
	System.out.println(list[0] * list[1]);
    }

    public static void reverse(int pos, int len){
	
    }
    
}


public class SpiralMemory {

    public static void main(String[] args) {
	int n = 312051; // Input
	
	int x = 0;
	int y = 0;
	int i = 1;
	int r = 1;
	int o = 1;
	int l = -2;
	int d = -2;
	int e = -1;
	while (true){
	    if(i >= n){
		e = 0;
		break;
	    }
	    x += r;
	    i += r;
	    r += 2;
	    if(i >= n){
		e = 1;
		break;
	    }
	    y += o;
	    i += o;
	    o += 2;
	    if(i >= n){
		e = 2;
		break;
	    }
	    x += l;
	    i -= l;
	    l -= 2;
	    if(i >= n){
		e = 3;
		break;
	    }
	    y += d;
	    i -= d;
	    d -= 2;
	}
	switch(e){
	case 1: x -= (i - n);
		break;
	case 2: y -= (i - n);
		break;
	case 3:	x += (i - n);
		break;
	case 0:	y += (i - n);
		break;
	}
	System.out.println(Math.abs(x)+Math.abs(y));
    }

}

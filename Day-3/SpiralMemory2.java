public class SpiralMemory2 {

    static int[][] mx = new int[10001][10001];
    static int val = 1;
    static int x = mx.length / 2 + 1;
    static int y = mx[0].length / 2 + 1;

    public static void main(String[] args) {
	int n = 312051; // Input
	mx[y][x] = 1;
	++x;
	mx[y][x] = 1;
	while (val < n) {
	    while(mx[y][x-1] != 0 && val < n)
		goUp();
	    while(mx[y+1][x] != 0 && val < n)
		goLeft();
	    while(mx[y][x+1] != 0 && val < n)
		goDown();
	    while(mx[y-1][x] != 0 && val < n)
		goRight();
	}
	System.out.println(val);
    }
    
    static void goUp(){
	y -= 1;
	val = getVal(x,y);
	mx[y][x] = val;
    }
    static void goDown(){
	y +=1;
	val = getVal(x,y);
	mx[y][x] = val;
    }
    static void goLeft(){
	x -= 1;
	val = getVal(x,y);
	mx[y][x] = val;
    }
    static void goRight(){
	x +=1;
	val = getVal(x,y);
	mx[y][x] = val;
    }

    static int getVal(int x, int y) {
	int val = 0;
	for (int i = -1; i <= 1; ++i) {
	    for (int j = -1; j <= 1; ++j) {
		if (i == 0 && j == 0)
		    continue;
		val += mx[y + i][x + j];
	    }
	}
	return val;
    }

}

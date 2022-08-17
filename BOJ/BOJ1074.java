import java.util.Scanner;

public class BOJ1074 {
	static int N;
	static int x,y;
	static int[][] map;
	static int ans;
	static int p;
	static void rec(int s,int e, int size,int num,int ans) {
		if(size == 0) {
			return;
		}
		if(s==x && e == y) {
			System.out.println(num);
			System.exit(0);
		} else {
			ans = ans/4;
			
			if(x<s+size/2 && y<e+size/2)
				rec(s,e ,size/2,num,ans);
			if(x<s+size/2 && y>=e+size/2)
				rec(s,e+size/2 ,size/2,num+ans,ans);
			if(x>=s+size/2 && y<e+size/2)
				rec(s+size/2,e ,size/2,num+ans*2,ans);
			if(x>=s+size/2 && y>=e+size/2)
				rec(s+size/2,e+size/2 ,size/2,num+ans*3,ans);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int k = 10; k>=0;k-- ) {
			System.out.println(k);
		}
		N = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		p = (int) Math.pow(2,N);
		ans = (int) Math.pow(p,2);
		rec(0,0,p,0,ans);
		
		
	}

}

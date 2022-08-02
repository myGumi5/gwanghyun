import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {

	static int white = 0;
	static int blue = 0;
	static int[][] box = null;
	static int N = 0;

	static void rec(int x, int y, int n) {
		System.out.println(n);
		if(n == 0) {
			return;
		}
		
		int w = 0, b = 0;
		if(x==4 && n ==2 && y==0) {
			
			
			System.out.println("dddddddd");
			
		}
		for(int i = x; i<x+n;i++) {
			for(int j = y; j<y+n;j++) {
				if(box[i][j] == 0) {
					w++;
				} else {
					b++;
				}
				if(w!=0 && b!=0) {
					break;
				}
			}			
		}
		if(w==n*n) {
			white++;
			return;
		} 
		if(b==n*n) {
			blue++;
			return;
		} 
		rec(x,y,n/2);
		rec(x,y+n/2,n/2);
		rec(x+ n/2,y,n/2);
		rec(x+n/2,y+n/2,n/2);
			
	}

	public static void main(String[] args) {
		FastIn fi = new FastIn();
		N = fi.nextInt();
		box = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				box[i][j] = fi.nextInt();
			}
		}
		rec(0,0,N);
		System.out.println(white);
		System.out.println(blue);
	}

	static class FastIn {
		BufferedReader br;
		StringTokenizer st;

		public FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {

			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}

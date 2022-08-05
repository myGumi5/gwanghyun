import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {

	static int N= 0,r=0,c=0, ans = 0;
	
	static void rec(int x, int y, int n) {
		if (r <= x-n/2) {
			x = x-(int)Math.pow(2, n/2);
			ans -= (int)Math.pow(2, n)*2;
		} 
		if (c <= y-n/2) {
			y = y-(int)Math.pow(2, n/2);
			ans -= (int)Math.pow(2, n);
		}
		if(x==r && y ==c)
			return;
		rec(x,y,n/2);
			
	}

	public static void main(String[] args) {
		FastIn fi = new FastIn();
		N = fi.nextInt();
		r = fi.nextInt();
		c = fi.nextInt();
		int n = (int)Math.pow(2, N)*(int)Math.pow(2, N);
		ans = n-1;
		rec((int)Math.pow(2, N)-1,(int)Math.pow(2, N)-1,N);
		System.out.println(ans);
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

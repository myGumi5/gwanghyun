import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11660 {

	public static void main(String[] args) {
		FastIo sc = new FastIo();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] dp = new int[N+1][N+1];

		for (int i = 1; i <=N;i++) {
			for (int j = 1; j <=N;j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + sc.nextInt();
			}
		}
		
		for(int i =0 ; i<M;i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			System.out.println(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);
			
		}
	}
	static class FastIo{
		BufferedReader br;
		StringTokenizer st;
		
		FastIo(){
			try {
			br = new BufferedReader(new InputStreamReader(System.in));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}
}

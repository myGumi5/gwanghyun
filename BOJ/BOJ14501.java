import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14501 {
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		
		int N = sc.nextInt();
		int[] dp = new int[N+2];
		int T = 0;
		int P = 0;
		int max = 0;
		for (int i=1;i<N+1;i++) {
			T = sc.nextInt();
			P = sc.nextInt();
			dp[i] = Math.max(dp[i-1], dp[i]);
			if(i+T>N+1)
				continue;
			dp[i + T] = Math.max(dp[i] + P, dp[i+T]);
			max = Math.max(dp[i+T], max);
		}
		System.out.println(max);
	}
	
	
	
	
	static class FastIn {
		BufferedReader br;
		StringTokenizer st;
		
		public FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			
			while(st ==null||!st.hasMoreElements()) {
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

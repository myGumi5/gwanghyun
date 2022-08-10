import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2293 {

	public static void main(String[] args) {
		FastIo sc = new FastIo();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n + 1];
		int[][] dp = new int[n+1][k+1];
		for (int i = 1; i < n + 1; i++) {
			coin[i] = sc.nextInt();
		}
		
		for(int i =1;i<n+1;i++) {
			for(int j=1;j<k+1;j++) {
				if(coin[i]>j) {
					dp[i][j] = dp[i-1][j];
				} else if (coin[i] == j) {
					dp[i][j] = dp[i-1][j] + 1;
				} else{
				
					dp[i][j] = dp[i][j-coin[i]]+dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n][k]);
	}

	static class FastIo {
		BufferedReader br;
		StringTokenizer st;

		FastIo() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2559 {

	public static void main(String[] args) {
		FastIo sc = new FastIo();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] dp = new int[N+1];
		for(int i =1;i<=N;i++) {
			dp[i] = dp[i-1] + sc.nextInt();
		}
		int max = Integer.MIN_VALUE;
		for(int i =M ; i<=N;i++) {
			max = Math.max(dp[i]-dp[i-M], max);
		}
		System.out.println(max);
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

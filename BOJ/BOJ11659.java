import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11659 {

	public static void main(String[] args) {
		FastIo sc = new FastIo();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] dp = new int[N+1];
		dp[1] = sc.nextInt();
		for(int i =2;i<=N;i++) {
			dp[i] = dp[i-1] + sc.nextInt();
		}
		for(int i =0 ; i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(dp[b]-dp[a-1]);
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

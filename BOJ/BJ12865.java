import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ12865 {
	//평범한 배낭
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] bag = new int[N+1][K+1];
		int[][] input = new int[3][N+1];
		for (int i=1;i<N+1;i++) {
			input[1][i] = sc.nextInt();
			input[2][i] = sc.nextInt();
		}
		
		for(int i = 1;i<N+1;i++) {
			for (int j = 1;j<K+1;j++) {
				int w = input[1][i];
				int v = input[2][i];
				
				if(j < w) {
					bag[i][j] = bag[i-1][j];
				} else {
					bag[i][j] = Math.max(bag[i-1][j], bag[i-1][j-w] + v);
				}
				
			}
		}
		System.out.println(bag[N][K]);
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

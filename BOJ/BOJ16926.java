import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {
	static int N ;
	static int M ;
	static int R ;
	static int[][] tmp;
	static void run(int[][] box , int k) {
		//if(n==N/2 || n == M/2) return;
		int[][] tmp= new int[N][M];
		for(int i = 0; i<N;i++) {
			for(int j =0 ;j<M;j++) {
				tmp[i][j] = box[i][j];
			}
		}
		for(int n = 1;n<=k ;n++) {
			tmp[n-1][n-1]= box[n-1][n];
			tmp[n-1][M-n]= box[n][M-n];
			tmp[N-n][M-n] = box[N-n][M-n-1];
			tmp[N-n][n-1] = box[N-n-1][n-1];
			for(int i = n;i<M-n;i++) {
				tmp[n-1][i] = box[n-1][i+1];
			}
			for(int i = n;i<N-n;i++) {
				tmp[i][M-n] = box[i+1][M-n];
			}
			for(int i = n;i<M-n;i++) {
				tmp[N-n][i] = box[N-n][i-1];
			}
			for(int i = n;i<N-n;i++) {
				tmp[i][n-1] = box[i-1][n-1];
			}
		}
		for(int i = 0; i<N;i++) {
			for(int j =0 ;j<M;j++) {
				box[i][j] = tmp[i][j];
			}
		}

	}
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		int[][] box = new int[N][M];
		tmp = new int[N][M];
		for(int i = 0; i<N;i++) {
			for(int j =0 ;j<M;j++) {
				box[i][j] = sc.nextInt();
			}
		}
		for(int r = 0; r <R;r++) {
			run(box,Math.min(N, M)/2);
		}
		for(int i = 0; i<N;i++) {
			for(int j =0 ;j<M;j++) {
				System.out.print(box[i][j]+" ");
			}
			System.out.println();
		}
	}
	static class FastIn{
		BufferedReader br;
		StringTokenizer st;
		FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st==null||!st.hasMoreElements()) {
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

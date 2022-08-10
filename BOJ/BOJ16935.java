import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ16935 {
	static int[][] box;
	static int N,M,R;
	static void case1() {
		for(int i =0;i<N/2;i++) {
			int e = N-1-i;
			int[] tmp = null;
			tmp = box[i];
			box[i] = box[e];
			box[e] = tmp;
		}
	}
	static void case2() {
		for(int i =0;i<N;i++) {
			for(int j = 0;j<M/2;j++) {
				int e = M-1-j;
				int tmp;
				tmp = box[i][j];
				box[i][j] = box[i][e];
				box[i][e] = tmp;
			}
		}
	}
	static void case3() {
		int[][] tmp = new int[M][N];
		for(int i =0;i<M;i++) {
			for(int j = N-1;j>=0;j--) {
				tmp[i][N-1-j] = box[j][i];
			}
		}
		box =tmp;
	}
	static void case4() {
		int[][] tmp = new int[M][N];
		for(int i =0;i<M;i++) {
			for(int j = 0;j<N;j++) {
				tmp[i][j] = box[j][M-1-i];
			}
		}
		box =tmp;
	}
	static void case5() {
		int[][] tmp = new int[N][M];
		for(int i =0;i<N/2;i++) {
			for(int j = 0;j<M/2;j++) {
				tmp[i][j+M/2] = box[i][j];
			}
		}
		for(int i =0;i<N/2;i++) {
			for(int j = M/2;j<M;j++) {
				tmp[i+N/2][j] = box[i][j];
			}
		}
		for(int i =N/2;i<N;i++) {
			for(int j = M/2;j<M;j++) {
				tmp[i][j-M/2] = box[i][j];
			}
		}
		for(int i =N/2;i<N;i++) {
			for(int j = 0;j<M/2;j++) {
				tmp[i-N/2][j] = box[i][j];
			}
		}
		box =tmp;
	}
	static void case6() {
		int[][] tmp = new int[N][M];
		for(int i =0;i<N/2;i++) {
			for(int j = 0;j<M/2;j++) {
				tmp[i+N/2][j] = box[i][j];
			}
		}
		for(int i =N/2;i<N;i++) {
			for(int j = 0;j<M/2;j++) {
				tmp[i][j+M/2] = box[i][j];
			}
		}
		for(int i =N/2;i<N;i++) {
			for(int j = M/2;j<M;j++) {
				tmp[i-N/2][j] = box[i][j];
			}
		}
		for(int i =0;i<N/2;i++) {
			for(int j = M/2;j<M;j++) {
				tmp[i][j-M/2] = box[i][j];
			}
		}
		box =tmp;
	}
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		box = new int[N][M];
		for(int i = 0; i<N;i++) {
			for(int j =0 ;j<M;j++) {
				box[i][j] = sc.nextInt();
			}
		}
		for(int r = 0 ; r<R;r++) {
			int command = sc.nextInt();
			switch(command) {
			case 1:
				case1();
				break;
			case 2:
				case2();
				break;
			case 3:
				case3();
				break;
			case 4:
				case4();
				break;
			case 5:
				case5();
				break;
			case 6:
				case6();
				break;
			}
			N = box.length;
			M = box[0].length;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406 {
	static int N,M,R;
	static void rec(int[][] box, int a, int b, int s) {
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		for(int j = 0;j<s;j++) {
			int x = a-s+j;
			int y = b-s+j;
			int tmp = box[x][y];
			int d = 0;
			while(d<4) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if (ny >= b-s+j && nx >= a-s+j && nx <= a+s-j && ny <= b+s-j) {
					box[x][y] = box[nx][ny];
					x = nx;
					y = ny;
				} else {
					d++;
				}
			}
			box[a-s+j][b-s+j+1] = tmp;
			
			
		}
		
	}
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		
		int[][] box = new int[N+1][M+1];
		for(int i = 1; i<N+1;i++) {
			for(int j =1 ;j<M+1;j++) {
				box[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i<R;i++) {
			rec(box,sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		for(int i = 1; i<N+1;i++) {
			for(int j =1 ;j<M+1;j++) {
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

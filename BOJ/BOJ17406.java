import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class info{
	int a, b, s;

	public info(int a, int b, int s) {
		super();
		this.a = a;
		this.b = b;
		this.s = s;
	}
}



public class BOJ17406 {
	static int N,M,K;
	static boolean[] v;
	static info[] infos;
	static int sum = Integer.MAX_VALUE;
	static void dfs(int n, int[][] tmp) {
		if(n==K) {
			int s = Integer.MAX_VALUE;
			for(int i = 1; i<N+1;i++) {
				int min = 0;
				for(int j = 1; j <M+1;j++) {
					min += tmp[i][j];
					
				}
				s= Math.min(s, min);
			}
			sum = Math.min(sum, s);
			return;
		} else {
			for(int i = 0;i<K;i++) {
				if(!v[i]) {
					v[i] = true;
					int[][] toss = new int[N+1][M+1];
					for(int j = 1; j<N+1;j++) {
						for(int k =1 ;k<M+1;k++) {
							toss[j][k] = tmp[j][k];
						}
					}
					rec(toss,infos[i].a,infos[i].b,infos[i].s);
					dfs(n+1, toss);
					v[i] = false;
				}
			}
		}
	}
	
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
		K = sc.nextInt();
		infos = new info[K];
		
		int[][] box = new int[N+1][M+1];
		v= new boolean[K];
		for(int i = 1; i<N+1;i++) {
			for(int j =1 ;j<M+1;j++) {
				box[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i<K;i++) {
			infos[i] = new info(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		dfs(0,box);
		System.out.println(sum);
		
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

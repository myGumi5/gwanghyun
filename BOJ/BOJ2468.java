import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class BOJ2468 {
	
	static class Xy{
		int x,y;

		public Xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static boolean[][] v;
	static int[][] box;
	static void bfs(Xy xy, int H) {
		Queue<Xy> q = new LinkedList<>();
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		q.add(xy);
		v[xy.x][xy.y] = true;
		while(!q.isEmpty()) {
			Xy tmp = q.poll();
			for(int i =0;i<4;i++) {
				int nx = tmp.x + dx[i]; 
				int ny = tmp.y + dy[i]; 
				if(nx<0||nx>=v.length||ny<0||ny>=v.length||v[nx][ny]) {
					continue;
				}
				v[nx][ny] = true;
				if(box[nx][ny] >H) {
					q.add(new Xy(nx,ny));
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		int N = sc.nextInt();
		box = new int[N][N];
		int maxh = Integer.MIN_VALUE;
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				box[i][j] = sc.nextInt();
				maxh = Math.max(maxh, box[i][j]);
			}
		}
		int ans = 1;
		for(int H = 1;H<maxh;H++) {
			v = new boolean[N][N];
			int h = 0;
			for(int i =0;i<N;i++) {
				for(int j =0;j<N;j++) {
					if(!v[i][j] && box[i][j] >H) {
						h++;
						bfs(new Xy(i,j),H);
					}
				}
			}
			ans = Math.max(ans, h);
		}
		
		System.out.println(ans);
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

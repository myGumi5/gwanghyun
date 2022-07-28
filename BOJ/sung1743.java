import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1743 {
	static int[][] box = null;
	static boolean[][] visited = null;
	static int N,M,K;
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		box = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for (int i = 0; i<K;i++) {
			box[sc.nextInt()][sc.nextInt()] = 1;
		}
		
		for (int i = 1; i< N+1;i++) {
			for (int j =1; j<M+1; j++) {
				if(box[i][j]==1 && !visited[i][j])
				{
					bfs(i,j);
				}
				
			}
		}
		System.out.println(max);
	}
	static int max=0;
	static void bfs(int x, int y) {
		int size = 0;
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		Queue<xy> q = new LinkedList<>();
		q.add(new xy(x,y));
		while(!q.isEmpty()) {
			size++;
			xy tmp = q.poll();
			visited[tmp.x][tmp.y] = true;
			for(int i =0;i<4;i++) {
				int nx = tmp.x+dx[i];
				int ny = tmp.y+dy[i];
				if(nx<1||nx>N||ny<1||ny>M || visited[nx][ny] || box[nx][ny] == 0) {
					continue;
				}
				q.add(new xy(nx,ny));
			}
		}
		max = Math.max(max, size);
	}
	
	static class xy {
		int x,y;
		xy(int a, int b){
			x = a;
			y = b;
		}
	}
	
	
	static class FastIn {
		BufferedReader br;
		StringTokenizer st;
		
		public FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null||!st.hasMoreElements()) {
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

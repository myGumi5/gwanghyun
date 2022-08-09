import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int x,y;

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class BOJ16234 {

	static int[][] box;
	static boolean[][] visited;
	static int N,L,R;
	static int ans = 0;
	
	static Queue<LinkedList<Pos>> q = new LinkedList<>();
	public static boolean bfs(Pos pos) {
		boolean flag = false;
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		LinkedList<Pos> list = new LinkedList<>();
		Queue<Pos> qs = new LinkedList<>();
		qs.add(pos);
		list.add(pos);
		visited[pos.x][pos.y] = true;
		while(!qs.isEmpty()) {
			Pos tmp = qs.poll();
			for(int i =0;i<4;i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				if(nx>=0&&nx<N&&ny>=0&&ny<N&& !visited[nx][ny]) {
					int sub = Math.abs(box[tmp.x][tmp.y]-box[nx][ny]);
					if(sub>=L && sub<=R) {
						visited[nx][ny] = true;
						Pos newPos = new Pos(nx,ny);
						list.add(newPos);
						qs.add(newPos);
					}
				}
			}
		}
		if(list.size() == 1) {
			return false;
		} else {
			q.add(list);
			return true;
		}
		
	}
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		N  = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		box = new int[N][N];
		
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				box[i][j] = sc.nextInt();
			}			
		}
		while(true) {
			visited = new boolean[N][N];
			q = new LinkedList<>();
			boolean flag = false;
			int cnt = 0;
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<N;j++) {
					if(!visited[i][j]&&bfs(new Pos(i,j))) {
						flag = true;
					}
				}
			}
			if(flag) {
				while(!q.isEmpty()) {
					LinkedList<Pos> list = q.poll();
					int sum = 0;
					for(int i =0;i<list.size();i++) {
						int x = list.get(i).x;
						int y = list.get(i).y;
						
						sum += box[x][y];
					}
					sum = sum / list.size();
					for(int i =0;i<list.size();i++) {
						int x = list.get(i).x;
						int y = list.get(i).y;
						box[x][y] = sum;
					}
				}
				ans++;
			} else {
				break;
			}
		}
		System.out.println(ans);
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

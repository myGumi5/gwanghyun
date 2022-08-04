import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class xy2 {
	int x,y,p;

	public xy2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "xy [x=" + x + ", y=" + y + "]";
	}
	
	
}

public class BJ1245 {
	static int N = 0;
	static int M = 0;
	static int[][] box = null;
	static boolean[][] visited = null;
	static int cnt= 0;
	static void bfs(xy2 t) {
		Queue<xy2> q = new LinkedList<>();
		int dx[] = {0,0,1,-1,-1,-1,1,1};
		int dy[] = {1,-1,0,0,-1,1,-1,1};
		
		
		visited[t.x][t.y] = true; 
		q.add(t);
		boolean c = true;
		
		while(!q.isEmpty()) {
			xy2 xy = q.poll();
			for (int i = 0; i <8;i++) {
				int nx = xy.x + dx[i];
				int ny = xy.y + dy[i];
				
				if(nx<0||nx>=N||ny<0||ny>=M) {
					continue;
				}
				if(box[xy.x][xy.y] < box[nx][ny]) {
					c = false;
				} 
				if (box[xy.x][xy.y] != box[nx][ny]){
					continue;
				}
				if(visited[nx][ny])
					continue;
				visited[nx][ny] = true;
				q.add(new xy2(nx,ny));
			}
		}
		if(c)
			cnt ++;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		box = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i =0 ; i<N;i++) {
			for(int j =0 ; j<M;j++) {
				box[i][j] = sc.nextInt();
			}
		}
		
		for(int i =0 ; i<N;i++) {
			for(int j =0 ; j<M;j++) {
				if(!visited[i][j] && box[i][j] != 0) {
					bfs(new xy2(i,j));
				}
			}
		}
		
		System.out.println(cnt);
	}

}

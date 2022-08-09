import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Xy{
	int x , y;

	public Xy(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class SWEA1861 {
	
	static void BFS(int x, int y) {
		Queue<Xy> q = new LinkedList<>();
		q.add(new Xy(x,y));
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		int t = 1;
		int tIdx = box[x][y];
		v[x][y] = true;
		while(!q.isEmpty()) {
			Xy tmp = q.poll();
			for(int i = 0 ; i <4 ;i++) {
				int nx = tmp.x+dx[i];
				int ny = tmp.y+dy[i];
				
				if(nx<0||nx>=N||ny<0||ny>=N||v[nx][ny]) {
					continue;
				}
				if(Math.abs(box[tmp.x][tmp.y]-box[nx][ny])!=1) {
					continue;
				}
				v[nx][ny] = true;
				t++;
				tIdx = Math.min(tIdx, box[nx][ny]);
				q.add(new Xy(nx,ny));
			}
		}
		if(t>max) {
			max = t ;
			idx= tIdx;
		} else if(t == max) {
			idx = Math.min(idx, tIdx);
		}
	}
	
	static int N;
	static int[][] box;
	static boolean[][] v;
	static int max = 0,idx = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			N = sc.nextInt();
			box = new int[N][N];
			v = new boolean[N][N];
			max = 0;
			idx = 0;
			for(int i = 0; i<N;i++) {
				for(int j = 0; j <N ; j++) {
					box[i][j] = sc.nextInt();
				}
			}
			for(int i = 0; i<N;i++) {
				for(int j = 0; j <N ; j++) {
					if(!v[i][j])
						BFS(i,j);
					
				}
			}
			
			
			System.out.println("#"+t+" "+idx+" "+ max);
		}
	}

}

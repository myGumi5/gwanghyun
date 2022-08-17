import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Bird{
	int x,y,pos;
	
	Bird(int x, int y, int pos){
		this.x = x;
		this.y = y;
		this.pos = pos;
	}
	
}

class Xy{
	int x,y;

	public Xy(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}


public class BOJ3197 {

	static List<Bird> birds = new ArrayList<>();
	static char[][] map;
	
	static boolean[][] union;

	static int R, C, day=0;
	
	static void bfs(Queue<Xy> q, Queue<Xy> w) {
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		boolean c = false;
		while(true) {
			
			Queue<Xy> tmp = new LinkedList<>();
			while(!q.isEmpty()) {
				Xy xy = q.poll();
				if(xy.x == birds.get(1).x && xy.y == birds.get(1).y) {
					c = true;
					break;
				}
				for(int i = 0;i<4;i++) {
					int nx = xy.x + dx[i];
					int ny = xy.y + dy[i];
					if(nx<0||nx>=R||ny<0||ny>=C || union[nx][ny]) {
						continue;
					}
					union[nx][ny] = true;
					if(map[nx][ny] == 'X') {
						tmp.add(new Xy(nx,ny));
						continue;
					}				
					q.add(new Xy(nx,ny));
				}
			}
			if(c) break;
			
			int size = w.size();
			for(int i = 0; i< size ; i++) {
				Xy xy = w.poll();
				
				for(int j = 0;j<4;j++) {
					int nx = xy.x + dx[j];
					int ny = xy.y + dy[j];
					if(nx<0||nx>=R||ny<0||ny>=C) {
						continue;
					}
					if(map[nx][ny] == 'X') {
						w.add(new Xy(nx,ny));
						map[nx][ny] = '.';
					}				
				}
			}
			q = tmp;
			day++;
		}
		
	}
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][];
		union = new boolean[R][C];
		Queue<Xy> water = new LinkedList<>();
		for(int i =0; i<R ; i++) {
			map[i] = sc.next().toCharArray();
				for(int j = 0; j<C;j++) {
					if(map[i][j] == 'L') {
						birds.add(new Bird(i,j,birds.size()+1));
					}
					if(map[i][j] != 'X')
						water.add(new Xy(i,j));
				}
		}
		Queue<Xy> q = new LinkedList<>();
		q.add(new Xy(birds.get(0).x,birds.get(0).y));
		union[birds.get(0).x][birds.get(0).y] = true;
		bfs(q, water);
		System.out.println(day);
		
//		System.out.println();
//		for(int i =0;i<R;i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(union[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
	}
	static class FastIn{
		BufferedReader br;
		StringTokenizer st;
		
		FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
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

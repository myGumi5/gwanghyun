import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2206 {
	static int N, M;
	static int[][] map;
	static int[][] dist;
	static boolean[][][] v;
	static boolean[][] v2;
	static int ans = Integer.MAX_VALUE;
	static class Point {
		int x, y, power, cnt;
		boolean[][] v;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.power = 1;
			cnt = 1;
		}

		public Point(int x, int y, int power, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.power = power;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		v = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		v[0][0][0] = true;
		//0일때만 가는놈 
		//근데 1을 발견하면 깨고 가는게 좋을수도 있음 
		// 1을 깨고 간 놈들은 체크를 해서 
		// 또 1 을 만나면 그쪽은 못가게 막아야함
		// 근데 이렇게 해버리면 메모리 초과가 뜸
		
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			
			int cnt = tmp.cnt;
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				int p = tmp.power;
				if(v[nx][ny][p]) {
					continue;
				}
				if(nx == N-1 && ny== M-1) {
					ans = Math.min(ans, tmp.cnt + 1); 
					continue;
				}
				if(map[nx][ny] == 1){
					if(tmp.power == 1) {
						p = p - 1;
					} else {
						continue; // 못깨
					}
				}
				v[nx][ny][p] = true;
				q.add(new Point(nx, ny, p, cnt + 1));
			}
		}
		if(ans == Integer.MAX_VALUE)
			ans = -1;
		if(N==1 && M==1) {
			ans = 1;
		}
		System.out.println(ans);
		
		
//		for(int i = 0 ; i< N;i++) {
//			for(int j = 0 ; j< M;j++) {
//				System.out.print(v[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i = 0 ; i< N;i++) {
//			for(int j = 0 ; j< M;j++) {
//				System.out.print(v2[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(Arrays.toString(v));

		//System.out.println(dist[N-1][M-1]);
		//System.out.println(c);
	}

}

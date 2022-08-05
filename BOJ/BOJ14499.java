import java.util.Arrays;
import java.util.Scanner;

public class BOJ14499 {
	static class Cube {
		int top,bottom,m1,m2,m3,m4;

		public Cube() {
			super();
		}

		public Cube(int top, int bottom, int m1, int m2, int m3, int m4) {
			super();
			this.top = top;
			this.bottom = bottom;
			this.m1 = m1;
			this.m2 = m2;
			this.m3 = m3;
			this.m4 = m4;
		}
	}
	
	static int[][] map = null;
	static int N, M, x, y, K;
	static int[] tc = null;
	
	static int aPoint = 1;
	static int bPoint = 1;
	static int[] a = new int[4];
	static int[] b = new int[4];
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	static Cube cube = new Cube();
	public static void main(String[] args) {
		init();
		run();
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		K = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		tc = new int[K];
		for (int i = 0; i < K; i++) {
			tc[i] = sc.nextInt();
		}
	}

	static void run() {
		for (int t = 0; t < K; t++) {
			int command = tc[t];
			int nx = x + dx[command];
			int ny = y + dy[command];
			if (!boundryCheck(nx, ny))
				continue;
			x = nx;
			y = ny;
			doit(command);
			
		}
	}
	static void doit(int command) {
		Cube tmp = new Cube(cube.top,cube.bottom,cube.m1,cube.m2,cube.m3,cube.m4);
		if(command == 1) {
			cube.top = tmp.m1;
			cube.bottom = tmp.m3;
			cube.m1 = tmp.bottom;
			cube.m3 = tmp.top;
		}
		if(command == 2) {
			cube.top = tmp.m3;
			cube.bottom = tmp.m1;
			cube.m1 = tmp.top;
			cube.m3 = tmp.bottom;
		}
		if(command == 3) {
			cube.top = tmp.m2;
			cube.bottom = tmp.m4;
			cube.m2 = tmp.bottom;
			cube.m4 = tmp.top;
		}
		if(command == 4) {
			cube.top = tmp.m4;
			cube.bottom = tmp.m2;
			cube.m2 = tmp.top;
			cube.m4 = tmp.bottom;
		}
		if(map[x][y] == 0) {
			map[x][y] = cube.bottom;
		} else {
			cube.bottom = map[x][y];
			map[x][y] = 0;
		}
		System.out.println(cube.top);
//		int oppnum = 0;
//		System.out.println("@@@@@@ do it@@@@@");
//		System.out.println("방위 : " + command );
//		System.out.println( "맵 : "+map[x][y]);
//		System.out.println("주사위 좌표 x :" +x + "  y : "+y);
//		if(command == 1 || command == 2) {
//			moveBPoint(command);
//			System.out.println("B포인트 : "+bPoint);
//			oppnum = (bPoint+2) % 4;
//			if(map[x][y] == 0) {
//				map[x][y] = b[oppnum];
//			}
//			if(b[oppnum] == 0) {
//				b[oppnum] = map[x][y];
//				map[x][y] = 0;
//			}
//			if(oppnum == 3) {
//				a[3] = b[3];
//			}
//			if(oppnum == 1) {
//				a[1] = b[1];
//			}
//			System.out.println(b[bPoint]);
//		} else {
//			moveAPoint(command);
//			System.out.println("A포인트 : "+aPoint);
//			oppnum = (aPoint+2)%4;
//			if(map[x][y] == 0) {
//				map[x][y] = a[oppnum];
//			}
//			if(b[oppnum] == 0) {
//				a[oppnum] = map[x][y];
//				map[x][y] = 0;
//			}
//			if(oppnum == 3) {
//				b[3] = a[3];
//			}
//			if(oppnum == 1) {
//				b[1] = a[1];
//			}
//			System.out.println(a[aPoint]);
//		}
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
//		System.out.println("###### end ######");
	}
	
	static boolean boundryCheck(int x, int y) {
		if (x < 0 || x == N || y < 0 || y == M)
			return false;
		return true;
	}

//	static void moveBPoint(int dir) { // 동 1 서 2
//		if (dir == 1)
//			bPoint = (bPoint - 1 + 4) % 4; // 음수 방지
//		else if (dir == 2)
//			bPoint = (bPoint + 1) % 4;
//	}
//	static void moveAPoint(int dir) { // 북 3 남 4
//		if (dir == 3)
//			aPoint = (aPoint + 1) % 4;
//		else if (dir == 4)
//			aPoint = (aPoint - 1 + 4) % 4; // 음수 방지
//	}

}

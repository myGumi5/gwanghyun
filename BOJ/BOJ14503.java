import java.util.Scanner;

public class BOJ14503 {
	static int N,M;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int ans =0;
	
	
	
	static void robot(int x, int y,int d) {
		int curX = x;
		int curY = y;
		int curD = d;
		int cnt = 0;
		while(true) {
			System.out.println(curD+ " : "+ cnt);
			
			if(map[curX][curY] == 0) {
				map[curX][curY] = 1;
				ans++;
				cnt = 0;
			}
			//  현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다
			int dir = (curD+3) % 4; // 현위치 왼쪽
			int nx = curX +dx[dir];
			int ny = curY +dy[dir];
			if(map[nx][ny] == 0) {
				curD = dir;
				curX = nx;
				curY = ny;
				continue;
			} else {
				if(cnt == 4) {
					curX = curX-dx[curD];
					curY = curY-dy[curD];
					if(map[curX][curY] == 1) {
						break;
					}
					cnt = 0;
					continue;
				}
				curD = dir;
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		robot(x,y,d);
		System.out.println(ans);
	}

}

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
			if(map[curX][curY] == 0) { // 현위치를 청소한다
				map[curX][curY] = -1; // 청소 완료
				ans++;
				cnt = 0;
			}
			//  현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다
			int dir = (curD+3) % 4; // 아직 회전 전인데 탐색부터 할거임
			int nx = curX +dx[dir];
			int ny = curY +dy[dir];
			if(map[nx][ny] == 0) {  // 왼쪽방향이 청소할 공간이면 
				curD = dir;
				curX = nx;
				curY = ny;
				continue;
			} else {
				if(cnt == 4) {
					curX -= dx[curD];
					curY -= dy[curD];
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
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println(ans);
	}

}

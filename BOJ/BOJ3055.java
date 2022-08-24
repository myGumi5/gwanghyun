import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ3055 {
	static int N, M;
	static char[][] map;
	static boolean[][] v;
	static Queue<int[]> water = new LinkedList<>();
	static Queue<int[]> dochi = new LinkedList<>();
	static int day = 0;
	static boolean BFS() {
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		while(true) {
			for(int i = 0, size = water.size(); i<size;i++) {
				int[] tmp = water.poll();
				int tmpx = tmp[0], tmpy = tmp[1];
				
				for(int d = 0; d<4;d++) {
					int nx = tmpx + dx[d]; 
					int ny = tmpy + dy[d];
					
					if(nx<0||nx>=N||ny<0||ny>=M||v[nx][ny]) {
						continue;
					}
					if(map[nx][ny] =='D' || map[nx][ny] == 'X') {
						continue;
					}
					v[nx][ny] = true;
					map[nx][ny] = '*';
					water.add(new int[] {nx,ny});
				}
			} // 물 끝
			for(int i = 0, size = dochi.size();i<size ; i++) { // 고슴도치
				int[] tmp = dochi.poll();
				int tmpx = tmp[0], tmpy = tmp[1];
				
				for(int d = 0; d<4;d++) {
					int nx = tmpx + dx[d]; 
					int ny = tmpy + dy[d];
					
					if(nx<0||nx>=N||ny<0||ny>=M||map[nx][ny] =='*'||map[nx][ny] == 'X' || map[nx][ny] == 'S') {
						continue;
					}
					dochi.add(new int[] {nx,ny});
					if(map[nx][ny] =='D') {
						day++;
						return true; // 물이 먼저 도착한거니 칵투스
					}
					map[nx][ny] = 'S';
				}		
			}
			if(dochi.size() == 0) {
				return false; // 칵투스 도치 사망 ㅠㅠ
			}
			day++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		v = new boolean[N][M];
		
		for(int i = 0; i<N;i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j<M;j++) {
				if(map[i][j] == '*') {
					water.add(new int[] {i,j});
				} 
				if(map[i][j] == 'S') {
					dochi.add(new int[] {i,j});
				}
			}
		}
		if(BFS()) {
			System.out.println(day);
		} else {
			System.out.println("KAKTUS");
		}
	}

}

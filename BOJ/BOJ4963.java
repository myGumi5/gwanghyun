import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ4963 {

	static int N,M;
	static int[][] map;
	static boolean[][] v;
	static void BFS(int[] pos) {
		Queue<int[]> q = new LinkedList<>();
		int[] dx = {0,0,1,-1,1,-1,1,-1};
		int[] dy = {1,-1,0,0,1,-1,-1,1};
		
		v[pos[0]][pos[1]] = true;
		q.add(pos);
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i = 0;i<8;i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				
				if(nx<0||nx>=N||ny<0||ny>=M|| v[nx][ny]) {
					continue;
				}
				v[nx][ny] = true;
				if(map[nx][ny] == 1)
					q.add(new int[] {nx,ny});
				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
 		while(true) {
 			M = sc.nextInt();
 			N = sc.nextInt();
 			if(N == 0) 
 				break;
 			map = new int[N][M];
 			v = new boolean[N][M];
 			for(int i = 0; i <N;i++) {
 				for(int j = 0; j <M;j++) {
 					map[i][j] = sc.nextInt();
 				}
 			}
 			int ans = 0;
 			for(int i = 0; i <N;i++) {
 				for(int j = 0; j <M;j++) {
 					if(map[i][j] == 1 && !v[i][j]) {
 						BFS(new int[] {i,j});
 						ans++;
 					}
 				}
 			}
 			System.out.println(ans);
 		}

	}

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CCTV {
	int dir;
	int x, y;
	public CCTV(int dir,int x, int y) {
		super();
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
	
}

public class BOJ15683 {
	static int N ;
	static int M ;
	static int[][] map;
	static List<CCTV> tvs;
	static int max = Integer.MAX_VALUE;
	static void back(int tmp[][] ,int[][] mapx) {
		for(int k =0;k <N;k++) {
			for(int w =0;w <M;w++) {
				tmp[k][w] = mapx[k][w];
			}
		}
	}
	static void dfs(int index,int n ,int[][] mapx) {
		if(n == tvs.size()) {
			int cnt = 0;
			for(int i = 0 ;i<N;i++) {
				for(int j = 0 ;j<M;j++) {
					if(mapx[i][j] == 0) {
						cnt++;
					}
				}
			}
			max = Math.min(max, cnt);
			return;
		} else {
			int[][] tmp = new int[N][M];
			back(tmp,mapx);
			for(int i = index; i <tvs.size();i++) {
				if(tvs.get(i).dir == 1) {
					for(int k = tvs.get(i).x -1; k>=0;k-- ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					dfs(i+1,n+1,tmp);
					//백트래킹
					back(tmp,mapx);
					
					for(int k = tvs.get(i).x + 1; k<N;k++ ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					dfs(i+1,n+1,tmp);
					back(tmp,mapx);
					
					for(int k = tvs.get(i).y + 1; k<M;k++ ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					dfs(i+1,n+1,tmp);
					
					back(tmp,mapx);
					
					for(int k = tvs.get(i).y - 1; k>=0;k-- ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					dfs(i+1,n+1,tmp);
					
					back(tmp,mapx);
				} else if (tvs.get(i).dir == 2) {
					
					for(int k = tvs.get(i).x -1; k>=0;k-- ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					for(int k = tvs.get(i).x + 1; k<N;k++ ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					
					dfs(i+1,n+1,tmp);
					
					//백트래킹
					back(tmp,mapx);
					///////////// 두번째
					
					for(int k = tvs.get(i).y + 1; k<M;k++ ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					for(int k = tvs.get(i).y - 1; k>=0;k-- ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					dfs(i+1,n+1,tmp);
					back(tmp,mapx);
				} else if (tvs.get(i).dir == 3) {

					//1번  마이너스 플러스 
					for(int k = tvs.get(i).x -1; k>=0;k-- ) {  
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					for(int k = tvs.get(i).y + 1; k<M;k++ ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					
					dfs(i+1,n+1,tmp);
					back(tmp,mapx);
					
					//2 번  플러스 플러스
					for(int k = tvs.get(i).x + 1; k<N;k++ ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					
					for(int k = tvs.get(i).y + 1; k<M;k++ ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					
					dfs(i+1,n+1,tmp);
					back(tmp,mapx);
					
					//3번 플러스 마이너스
					
					for(int k = tvs.get(i).x + 1; k<N;k++ ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					for(int k = tvs.get(i).y - 1; k>=0;k-- ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					dfs(i+1,n+1,tmp);
					back(tmp,mapx);
					
					//4번 마이너스 마이너스
					for(int k = tvs.get(i).x -1; k>=0;k-- ) {  
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					for(int k = tvs.get(i).y - 1; k>=0;k-- ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					dfs(i+1,n+1,tmp);
					back(tmp,mapx);
				} else if(tvs.get(i).dir == 4) {
					//첫번째
					for(int k = tvs.get(i).x -1; k>=0;k-- ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					for(int k = tvs.get(i).x + 1; k<N;k++ ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					for(int k = tvs.get(i).y + 1; k<M;k++ ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					
					dfs(i+1,n+1,tmp);
					back(tmp,mapx);
					
					for(int k = tvs.get(i).x -1; k>=0;k-- ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					for(int k = tvs.get(i).x + 1; k<N;k++ ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					for(int k = tvs.get(i).y - 1; k>=0;k-- ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					
					dfs(i+1,n+1,tmp);
					
					back(tmp,mapx);
					///////////// 두번째
					
					for(int k = tvs.get(i).y + 1; k<M;k++ ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					for(int k = tvs.get(i).y - 1; k>=0;k-- ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					for(int k = tvs.get(i).x -1; k>=0;k-- ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					dfs(i+1,n+1,tmp);
					back(tmp,mapx);
					
					for(int k = tvs.get(i).y + 1; k<M;k++ ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					for(int k = tvs.get(i).y - 1; k>=0;k-- ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					for(int k = tvs.get(i).x + 1; k<N;k++ ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					dfs(i+1,n+1,tmp);
					back(tmp,mapx);
					
				} else if(tvs.get(i).dir == 5){
					
					for(int k = tvs.get(i).y + 1; k<M;k++ ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					for(int k = tvs.get(i).y - 1; k>=0;k-- ) {
						if(tmp[tvs.get(i).x][k] == 6) {
							break;
						} else if(tmp[tvs.get(i).x][k] == 0)
							tmp[tvs.get(i).x][k] = -1;
					}
					for(int k = tvs.get(i).x + 1; k<N;k++ ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					for(int k = tvs.get(i).x -1; k>=0;k-- ) {
						if(tmp[k][tvs.get(i).y] == 6) {
							break;
						} else if(tmp[k][tvs.get(i).y] == 0)
							tmp[k][tvs.get(i).y] = -1;
					}
					dfs(i+1,n+1,tmp);
					back(tmp,mapx);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		int cnt = 0;
		tvs = new ArrayList<>();
		for(int i =0; i <N;i++) {
			for(int j = 0; j < M;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] >0 && map[i][j] <6) {
					tvs.add(new CCTV(map[i][j],i,j));
				}
			}
		}
		dfs(0,0,map);
		System.out.println(max);
	}

}

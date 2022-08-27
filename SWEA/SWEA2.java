import java.util.ArrayList;
import java.util.Scanner;

public class SWEA2 {

	static int T;
	static int N;
	static int[][] map;
	static ArrayList<int[]> thing;
	static boolean[] mon;
	static boolean[] house;
	static int[] pos = new int[2];
	static boolean[] v;
	static int ans = 1000000;
	static void dfs(int px,int py,int n,int distance) {
		int size = thing.size();
		if(n == size) {
			ans = Math.min(distance, ans);
			return;
		}
		
		for(int i=0; i<size; i++) {
			if(!v[i]) {
				int x = thing.get(i)[0] , y = thing.get(i)[1];
				int who = map[x][y];
				if(who>0) {  // 몬스터일때 
					mon[who] = true;
					v[i] = true;
					int dis = Math.abs(px-x) + Math.abs(py-y);
					dfs(x,y,n+1,distance+dis);
					v[i] = false;
					mon[who] = false;
				} else { // 사람일때
					if(!mon[-who]) { // 몬스터 방문을 안했다면
						continue; // 가지친다
					} else { //방문 되었다면 
						v[i] = true;
						int dis = Math.abs(px-x) + Math.abs(py-y);
						dfs(x,y,n+1,distance+dis);
						v[i] = false;
					}
				}
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t = 1;t<=T;t++) {
			N = sc.nextInt();
			map = new int[N][N];
			thing = new ArrayList<>();
			pos = new int[] {0,0};
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] != 0) {
						thing.add(new int[] {i,j});
					} 
				}
			}
			ans = 1000000;
			mon = new boolean[thing.size()/2+1];
			house = new boolean[thing.size()/2+1];
			v = new boolean[thing.size()+1];
			dfs(0,0,0,0);
			System.out.println(ans);
		}
	}

}

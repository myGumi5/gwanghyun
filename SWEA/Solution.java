import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int T,N;
	static int[] ans = new int[3];
	static int[][] map;
	static int[] v;
	static ArrayList<Home> homes;
	static int av = 2;
	static class Home{
		int x,y;
		int d;
		public Home(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
	}
	
	static void dfs(int x, int y, int check,int n) {
		if(check==N) {
			int sum = 0;
			for(int i = 0;i<N;i++) {
				sum += v[i];
			}
			ans[n] = Math.min(ans[n], sum);
			return;
		} // 1개 
		if(n>=2)
			return;
		for(int i = x;i<=30;i++) {
			for(int j = 0;j<=30;j++) {
				int cnt = 0;
				ArrayList<Integer> reset= new ArrayList<>();
				ArrayList<int[]> resets= new ArrayList<>();
				if(map[i][j] == 1) continue; // 집이있음
				for(int k = 0; k < N;k++) {
					int Man = Math.abs(homes.get(k).x -i) + Math.abs(homes.get(k).y -j);
					if(Man<=homes.get(k).d) {
						if(v[k]==0) { // 이미 더해진 집이라면 무시 n=1 
							v[k] = Man;
							cnt++;
							reset.add(k);
						} else {
							if(v[k]>Man) {
								resets.add(new int[] {k,v[k]});
								v[k] = Man;
							}
						}
					}
				}
				if(reset.size()>0) { 
					dfs(i,j,cnt+check,n+1);
					for(int k : reset) {
						v[k] = 0;
					}
				}
				for(int[] k : resets) {
					v[k[0]] = k[1];
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\ssafy\\Study\\Study\\src\\input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t= 1;t<=T;t++) {
			map = new int[31][31];
			N = sc.nextInt();
			homes = new ArrayList<>();
			v = new int[N];
			ans = new int[] {0,Integer.MAX_VALUE,Integer.MAX_VALUE};
			for(int i = 0;i<N;i++) {
				int y = sc.nextInt()+15;
				int x = sc.nextInt();
				x= Math.abs(x-15);
				homes.add(new Home(x,y,sc.nextInt()));
				map[x][y] = 1;
			}
			
			av = 2;
			
			dfs(0,0,0,0);
			//문제가 충전소 1개로 끝낼수있으면 
			// 무조건 1개인거중에서 제일 낮을 출력 
			// X 2개인거중에 제일 낮은거 출력 
			// -1
			int s = ans[1];
			if(ans[1] == Integer.MAX_VALUE) {
				s = ans[2];
			} 
			if(s == Integer.MAX_VALUE)
				s = -1;
			System.out.println("#"+t+" "+s);
		}
	}
}

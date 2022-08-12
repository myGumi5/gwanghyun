import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ15686 {

	static int N, M;
	static List<Integer[]> chicken;
	static List<Integer[]> home;
	static int[][] map;
	static boolean[] check;
	static int min = Integer.MAX_VALUE;
	static void backt(int index,int n) {
		if(n == M) {
			List<Integer> tmp=new ArrayList<>();
			
			for(int i =0; i < chicken.size();i++) {
				if(check[i]) {
					tmp.add(i);
				}
			}
			int minsum = 0;
			for(Integer[] h : home) {
				int distance = Integer.MAX_VALUE;
				int i = h[0];
				int j = h[1];
				for(Integer t : tmp) {
					distance = Math.min(Math.abs(chicken.get(t)[0]-i)+ Math.abs(chicken.get(t)[1]-j),distance);
				}
				minsum +=distance;
			}
			min = Math.min(min, minsum);
		} else {
			for(int i = index;i<chicken.size();i++) {
				if(!check[i]) {
					check[i] = true;
					backt(i+1,n+1);
					check[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		map = new int[N][N];
		for(int i = 0 ; i<N; i++) {
			for(int j = 0 ; j<N; j++) {
				int tmp = sc.nextInt();
				map[i][j] = tmp;
				if(tmp == 1) {
					home.add(new Integer[] {i,j});
				} else if(tmp == 2) {
					chicken.add(new Integer[] {i,j});
				}
			}
		}
		check = new boolean[chicken.size()];
		backt(0,0);
		System.out.println(min);
	}

}

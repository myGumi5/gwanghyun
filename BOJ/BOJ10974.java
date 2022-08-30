import java.util.Scanner;

public class BOJ10974 {
	static int N;
	static boolean[] v;
	
	static void dfs(int n,int[] tmp) {
		if(n==N) {
			for(int i = 0; i <N;i++) {
				System.out.print(tmp[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(!v[i]) {
				tmp[n] = i;
				v[i] = true;
				dfs(n+1,tmp);
				tmp[n] = 0;
				v[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		v = new boolean[N+1];
		dfs(0,new int[N]);
		
	}

}

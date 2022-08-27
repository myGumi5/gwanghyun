import java.util.Arrays;
import java.util.Scanner;

public class SWEA3 {
	static int T,N;
	static int[] card;
	static int ans=Integer.MAX_VALUE;
	static void dfs(int n,int[] cards) {
		if(n==6 || n>=ans) { // 6번 부턴 안본다.
			return;
		}
		
		if(isSorted(cards)) {
			ans = Math.min(ans, n);
			return;
		}
		
		for(int i =1;i<N;i++) {
			int[] tmp = shuffle(i,cards);
			dfs(n+1,tmp);
		}
	}
	static boolean isSorted(int[] cards) {
		boolean flag = true;
		boolean flag2 = true;
		for(int i = 0;i<N;i++) {
			if(i+1 != cards[i]) flag = false;
			if(N-i != cards[i]) flag2 = false;
			if(!flag&&!flag2) return false;
		}
		
		
		return true;
	}
	static int[] shuffle(int X, int[] shuffled) {
		int[] left = new int[N/2];
		int[] right = new int[N/2];
		int[] list = new int[N];
		int idx = 0;
		if(X<N/2) {
			for(int i = 0; i <N/2;i++) {
				left[i] = shuffled[i];
				right[i] = shuffled[i+N/2];
			}
		} else {
			for(int i = 0; i <N/2;i++) {
				right[i] = shuffled[i];
				left[i] = shuffled[i+N/2];
			}
			X = N - X - 1;
		}


		for(int i = 0; i<N/2-X;i++) {
			list[idx++] = left[i];
		}
		int cnt = 0;
		while(cnt<X) {
			list[idx++] = right[cnt];
			list[idx++] = left[N/2-X+cnt];
			cnt++;
		}
		for(int i = X; i<N/2;i++) {
			list[idx++] = right[i];
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			card = new int[N];
			for(int i= 0; i <N;i++) {
				card[i] = sc.nextInt();
			}
			ans = Integer.MAX_VALUE;
			dfs(0,card);
			if(ans == Integer.MAX_VALUE)
				ans = -1;
			System.out.println("#"+t+" "+ans);
		}
		
	}
}

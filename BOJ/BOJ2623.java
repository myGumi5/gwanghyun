import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2623 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer>[] list = new ArrayList[N+1];
		int[] topo = new int[N+1];
		for(int i = 1; i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int m = 0; m<M;m++) {
			int K = sc.nextInt();
			int[] tmp = new int[K];
			for(int k = 0;k<K;k++) {
				tmp[k] = sc.nextInt();
			}
			for(int k = 0; k<K-1;k++) {
				list[tmp[k]].add(tmp[k+1]);
				topo[tmp[k+1]]++; 
			}
		}
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1;i<=N;i++) {
			if(topo[i] == 0) {
				q.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int a : list[tmp]) {
				if(--topo[a] == 0) {
					q.add(a);
				}
			}
			cnt++;
			sb.append(tmp).append("\n");
		}
		if(cnt != N) {
			System.out.println(0);
		} else {
			System.out.println(sb);
		}
	}

}

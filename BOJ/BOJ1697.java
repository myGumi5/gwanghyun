import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BOJ1697 {
	static int[] v;
	public static void BFS(int n ,int k) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		while(!q.isEmpty()) {
			int tmp = q.poll();
			if(tmp == k) {
				break;
			} else {
				int[] dx = {-1,1,tmp};
				for(int i =0;i<3;i++) {
					int nx = tmp + dx[i];
					if(nx>=0 && nx<200000 && v[nx] == 0) {
					v[nx] = v[tmp] + 1;
					q.add(nx);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		v = new int[200001];
		BFS(N,K);
		System.out.println(v[K]);

	}

}

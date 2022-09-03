import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ13549 {
	static int N,K;
	static int[] dp = new int[200001];
	static final int MAX = 100000000;
	static class Point implements Comparable<Point> {
		int x,w;

		public Point(int x,int w) {
			super();
			this.x = x;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(w, o.w);
		}
		
		
	}
	static void Dijckstra(int n) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(n, dp[n]));

		while(!pq.isEmpty()) {
			Point tmp = pq.poll();
			int[] dx = {-1,1,tmp.x};
			if(tmp.x == K) break;
			for(int i = 0; i < 3;i++) {
				if(i==0) {
					if(tmp.x ==0) continue;
					if(dp[tmp.x+dx[i]] > dp[tmp.x] + 1) {
						dp[tmp.x+dx[i]] = dp[tmp.x] + 1;
					} else {
						continue;
					}
				}
				if(i==1) {
					if(tmp.x>K) continue;
					if(dp[tmp.x+dx[i]] > dp[tmp.x] + 1) {
						dp[tmp.x+dx[i]] = dp[tmp.x] + 1;
					} else {
						continue;
					}
				}
				if(i==2) {
					if(tmp.x>K) continue;
					if(dp[tmp.x+dx[i]] > dp[tmp.x]) {
						dp[tmp.x+dx[i]] = dp[tmp.x];
					} else {
						continue;
					}
				}
				pq.add(new Point(tmp.x+dx[i],dp[tmp.x+dx[i]]));
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		Arrays.fill(dp, MAX);
		dp[N] = 0;
		Dijckstra(N);
		System.out.println(dp[K]);
	}
	
}

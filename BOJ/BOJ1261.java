import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int[][] arr;
	static int[][] dp;
	
	static class Data implements Comparable<Data>{
		int x,y;
		int w;
		
		
		public Data(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}


		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
		
	}
	
	static int dijkstra() {
		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.add(new Data(0,0,arr[0][0]));
		dp[0][0] = arr[0][0];
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		while(!pq.isEmpty()) {
			Data d = pq.poll();
			for(int i =0; i<4;i++) {
				int nx = d.x + dx[i];
				int ny = d.y + dy[i];
				if(nx<0||nx>=N||ny<0||ny>=M)
					continue;
				if(dp[nx][ny]>dp[d.x][d.y]+arr[nx][ny]) {
					dp[nx][ny]=dp[d.x][d.y]+arr[nx][ny];
					pq.add(new Data(nx,ny,dp[nx][ny]));
				}
			}
		}
		
		return dp[N-1][M-1];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			M = sc.nextInt();
            N = sc.nextInt();
			arr = new int[N][M];
			dp = new int[N][M];
            for(int i = 0;i<N;i++) {
                String str = sc.next();
				for(int j = 0;j<M;j++) {
					arr[i][j] = str.charAt(j)-'0';
					dp[i][j] = 100000000;
				}
			}
			
			System.out.println(dijkstra());
	}

}
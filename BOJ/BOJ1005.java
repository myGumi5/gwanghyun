import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1005 {

	public static void main(String[] args) {
		FastIo sc = new FastIo();
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
			int N = sc.nextInt();
			int K = sc.nextInt();
			int sum = 0;
			boolean flag = false;
			int[] day = new int[N + 1];
			int[] polo = new int[N + 1];
			int[] dp = new int[N+1];
			for (int i = 0; i<=N;i++) {
				if(i != 0) {
					day[i] = sc.nextInt();
					dp[i] = day[i];
				}
				tree.add(new ArrayList<>());
			}
			for (int i = 0; i < K; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				tree.get(a).add(b);
				polo[b]++;
			}
			int win = sc.nextInt();
			
			// 시작 
			Queue<Integer> d = new LinkedList<>();
			for(int i = 1; i <= N; i++) {
				if(polo[i] == 0) {
					d.add(i);
				}
			}
			while(!d.isEmpty()) {
				int target = d.poll();
				if (target == win) {
					break;
				} else {
					int max = 0;
					for(int x : tree.get(target)) {
						dp[x] = Math.max(dp[x], day[x] + dp[target]);
						if(--polo[x]  == 0 ) {
							d.add(x);
						}
					}
				}
			}
			System.out.println(dp[win]);
		}

	}

	static class FastIo {
		BufferedReader br;
		StringTokenizer st;

		FastIo() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}

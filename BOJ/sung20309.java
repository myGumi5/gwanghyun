import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20309 {

	public static void main(String[] args) {
		FastIn fi = new FastIn();
		int n = fi.nextInt();
		for (int i = 1;i<=n;i++) {
			int k = fi.nextInt();
			if (i % 2 == 1 && k % 2 == 0 || i % 2 == 0 && k % 2 == 1) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
		
		
	}
	static class FastIn {
		BufferedReader br;
		StringTokenizer st;

		public FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {

			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}

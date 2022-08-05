import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2042 {

	static long[] data = null;
	static long[] tree = null;

	public static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = data[start];
		} else {
			init(node * 2, start, (start + end) / 2);
			init(node * 2 + 1, (start + end) / 2 + 1, end);
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
	}

	public static void update(int node, int start, int end, int index, long diff) {
		if (index < start || index > end) {
			return;
		}
		tree[node] += diff;
		if (start != end) {
			update(node * 2, start, (start + end) / 2, index, diff);
			update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
		}
	}

	public static long query(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		return query(node * 2, start, (start + end) / 2, left, right)
				+ query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}

	public static void main(String[] args) {
		FastIo fi = new FastIo();
		int N = fi.nextInt();
		int M = fi.nextInt();
		int K = fi.nextInt();
		data = new long[N + 1];
		tree = new long[30];
		for (int i = 1; i <= N; i++) {
			data[i] = fi.nextInt();
		}
		init(1, 1, N);

		for (int i=0; i<M+K;i++) {
			int c=fi.nextInt();
			if(c == 1) {
				int a = fi.nextInt();
				int b = fi.nextInt();
				long diff = b - data[a];
				data[a] = b;
				update(1, 1, N, a, diff);
			} else {
				int a = fi.nextInt();
				int b = fi.nextInt();
				System.out.println(query(1, 1, N, a, b));
			}
		} 
	}

	static class FastIo {
		BufferedReader br;
		StringTokenizer st;

		FastIo() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}
}

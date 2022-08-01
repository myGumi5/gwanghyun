import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1244 {
	// 스위치 켜고 끄기
	public static void main(String[] args) {
		FastIn fi = new FastIn();
		int N = fi.nextInt();
		int[] box = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			box[i] = fi.nextInt();
		}

		int M = fi.nextInt();

		for (int i = 0; i < M; i++) {
			int gender = fi.nextInt();
			int s = fi.nextInt();

			if (gender == 1) {
				for (int j = s; j <= N; j += s) {
					box[j] = box[j] == 1 ? 0 : 1;
				}
			} else {
				int j = 1;
				while (true) {
					if (s - j == 0 || s + j == N + 1 || box[s - j] != box[s + j]) {
						j--;
						break;
					}
					j++;
				}
				box[s] = box[s] == 1 ? 0 : 1;
				for (int k = 0; k < j; k++) {
					box[s + (k + 1)] = box[s + (k + 1)] == 1 ? 0 : 1;
					box[s - (k + 1)] = box[s - (k + 1)] == 1 ? 0 : 1;
				}

			}
		}
		int i = 0;
		while(i < N) {
			System.out.print(box[i+1] + " ");
			i++;
			if(i%20 ==0) {
				System.out.println();
			}
		}
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

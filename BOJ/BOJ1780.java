import java.util.Scanner;

public class BOJ1780 {

	static int[] paper = new int[3]; // -1 0 1

	static void recur(int x, int y, int n) {
		int[] tmp = new int[3];
		if (n == 0) {
			return;
		} else {

			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					if (tmp[0] != 0 && tmp[1] != 0 && tmp[2] != 0) {
						break;
					}
					tmp[box[i][j]]++;
				}
			}

			if (tmp[0] == n*n || tmp[1] == n*n || tmp[2] == n*n) {
				for (int i = 0; i < 3; i++) {
					if (tmp[i] > 0) {
						paper[i] ++;
						break;
					}
				}
			} else {
				int size = n / 3;
				recur(x, y, size);
				recur(x, y + size, size);
				recur(x, y + 2 * size, size);
				
				recur(x + size, y, size);
				recur(x + size, y + size, size);
				recur(x + size, y + 2 * size, size);
				
				recur(x + 2 * size, y, size);
				recur(x + 2 * size, y + size, size);
				recur(x + 2 * size, y + 2 * size, size);
			}
		}
	}

	static int[][] box = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		box = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				box[i][j] = sc.nextInt() + 1;
			}
		}

		recur(0, 0, N);

		for (int i = 0; i < 3; i++) {
			System.out.println(paper[i]);
		}
	}

}

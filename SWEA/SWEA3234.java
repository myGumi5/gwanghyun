import java.util.Arrays;
import java.util.Scanner;

public class SWEA3234 {

	static int T, N;
	static int[] arr;
	static int ans;

	static void prm(int n, int[] tmp, boolean[] v) {
		if (n == N) {
			powerSet(1, tmp, tmp[0], 0); // 첫번째 값은 무조건 왼쪽에 있어야한다.
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				tmp[n] = arr[i];
				prm(n + 1, tmp, v);
				v[i] = false;
			}
		}
	}

	static void powerSet(int n, int[] tmp, int left, int right) {
		if(n==N) {
			ans++;
			return;
		}
		left = left + tmp[n];
		powerSet(n+1,tmp,left,right);
		left = left - tmp[n];
		right = right + tmp[n];
		if(left>=right) {
			powerSet(n+1,tmp,left,right);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			prm(0, new int[N], new boolean[N]);
			System.out.println("#"+t+" "+ans);
		}
	}

}

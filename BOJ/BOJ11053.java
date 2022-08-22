import java.util.Arrays;
import java.util.Scanner;

public class BOJ11053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for(int i = 0; i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int max = 1;
		for(int i =1;i<N;i++) {
			int m = 0;
			for(int j = 0 ; j<i;j++) {
				if(arr[i]>arr[j]) {
					m = Math.max(m, dp[j]);
				}
			}
			dp[i] = m +1;
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}


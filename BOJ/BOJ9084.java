import java.util.Scanner;

public class BOJ9084 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			int[] arr = new int[N+1];
			for(int i =1;i<N+1;i++) {
				arr[i] = sc.nextInt();
			}
			int M = sc.nextInt();
			int[] coin = new int[M+1];
			for(int i = 1; i<N+1;i++) {
				for(int j = 1;j<M+1;j++) {
					if(j==arr[i]) {
						coin[j]++;
					} else if(j > arr[i]) {
						coin[j] = coin[j-arr[i]] + coin[j];
					}
				}
			}
			System.out.println(coin[M]);
		}
	}

}

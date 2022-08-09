import java.util.Scanner;

public class BOJ2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] box = new int[100][100];
		int ans = 0;
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int j = a;j<a+10;j++) {
				for(int k = b; k<b+10;k++) {
					box[j][k] = 1;
				}
			}
		}
		for(int i = 0 ; i<100; i++) {
			for(int j = 0 ; j<100; j++) {
				if(box[i][j] == 1)
					ans++;
			}			
		}
		System.out.println(ans);
	}

}

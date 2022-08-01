import java.util.Scanner;

public class Bj1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] triangle = new int[501][501];
		
		for(int i =1;i<=N;i++) {
			for(int j = 1;j<=i;j++) {
				triangle[i][j] = sc.nextInt();
			}
		}
		for(int i =2;i<=N;i++) {
			for(int j = 1;j<=i;j++) {
				if (j==1)
					triangle[i][j] += triangle[i-1][j];
				else if (j==N)
					triangle[i][j] += triangle[i-1][j-1];
				else
					triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]);
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=N;i++) {
			max = Math.max(max, triangle[N][i]);
		}
		System.out.println(max);
		
		
		
	}

}

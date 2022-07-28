import java.util.Scanner;

public class BJ9465 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =0; t<T;t++) {
			int N = sc.nextInt();
			int[][] card = new int[2][N];
			for(int i=0;i<2;i++) {
				for(int j =0;j<N;j++) {
					card[i][j] = sc.nextInt();
				}
			}
			if(N!=1) {
				card[0][1] += card[1][0];
				card[1][1] += card[0][0];
			}
			for(int j =2;j<N;j++) {
				card[0][j] += Math.max(card[1][j-1], card[1][j-2]); 
				card[1][j] += Math.max(card[0][j-1], card[0][j-2]); 
			}
			System.out.println(Math.max(card[0][N-1], card[1][N-1]));
			
		}
	}

}

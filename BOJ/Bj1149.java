import java.util.Scanner;

public class Bj1149 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] RGB = new int[N+1][3];
		
		for(int i =1;i<=N;i++) {
			RGB[i][0] = sc.nextInt();
			RGB[i][1] = sc.nextInt();
			RGB[i][2] = sc.nextInt();
		}
		for(int i =2;i<=N;i++) { 
			RGB[i][0] += Math.min(RGB[i-1][1], RGB[i-1][2]);
			RGB[i][1] += Math.min(RGB[i-1][0], RGB[i-1][2]);
			RGB[i][2] += Math.min(RGB[i-1][0], RGB[i-1][1]);
		}
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<3;i++)
			min = Math.min(min, RGB[N][i]);
		
		System.out.println(min);
		
	}

}

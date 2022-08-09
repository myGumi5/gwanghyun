import java.util.Arrays;
import java.util.Scanner;

public class SWEA1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int t= 1; t<=10;t++) {
			int N = sc.nextInt();
			int[] box = new int[100];
			for(int i =0;i<100;i++) {
				box[i] = sc.nextInt();
			}
			Arrays.sort(box);
			for(int j = 0; j<N;j++) {
				box[0]++;
				box[99]--;
				Arrays.sort(box);
			}
			System.out.printf("#%d %d%n",t,box[99]-box[0]);
		}
	}

}

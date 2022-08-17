import java.util.Scanner;

public class BOJ3003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = {1,1,2,2,2,8};
		
 		for(int i = 0; i <6; i++) {
			int n = sc.nextInt();
			System.out.print((a[i]-n) + " ");
		}

	}

}

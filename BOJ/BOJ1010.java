import java.util.Scanner;

public class BOJ1010 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T =  sc.nextInt();
		for(int t = 0;t<T;t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			//a= b-a;
			long n1 = 1;
			for(int j = 0; j < a; j++) {
				n1 *= (b - j);
				n1 /= (j + 1);
			}
			System.out.println(n1);
		}

	}

}

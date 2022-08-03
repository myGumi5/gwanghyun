import java.util.Scanner;

public class BOJ2675 {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			String str = sc.next();
			char[] c = str.toCharArray();
			for(int i = 0;i<c.length;i++) {
				for(int j =0;j<N;j++)
					System.out.print(c[i]);
			}
			System.out.println();
			
		}
	}

}

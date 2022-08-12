import java.util.Scanner;

public class BOJ1992 {

	static char[][] c;
	static void rec(int a,int b, int n) {
		boolean check = true;
		char tmp = c[a][b];
		for(int i = a; i<a+n;i++) {
			for(int j= b; j<b+n;j++) {
				if(c[i][j] != tmp) {
					check = false;
					break;
				}
			}
		}
		if(check) {
			System.out.print(tmp);
		} else {
			int nn = n/2;
			System.out.print("(");
			rec(a,b,nn);
			rec(a,b+nn,nn);
			rec(a+nn,b,nn);
			rec(a+nn,b+nn,nn);
			System.out.print(")");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		c = new char[N][];
		for(int i = 0 ; i<N;i++) {
			c[i] = sc.next().toCharArray();
		}
		rec(0,0,N);
	}

}

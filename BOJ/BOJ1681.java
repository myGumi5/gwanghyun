import java.util.Scanner;

public class BOJ1681 {

	static int N,L;
	
	static boolean dfs(int n, int p) {
		if(p==-1) {
			return true;
		} else {
			int check =  n / (int)Math.pow(10, p);
			if(check == L) {
				return false;
			}
			return dfs(n % (int)Math.pow(10, p),p - 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		int cnt = 0;
		int i = 1;
		for(i = 1; i<=10000000; i++) {
			int p = 0;
			if(i<10) {
				p=0;
			} else if(i<100) {
				p = 1;
			} else if (i <1000) {
				p = 2;
			} else if(i<10000) {
				p = 3;
			} else if(i<100000) {
				p = 4;
			} else if(i<1000000) {
				p = 5;
			} else {
				p = 6;
			}
			if(dfs(i,p)) {
//				System.out.print(i + " ");
				cnt++;
			}
			if(cnt==N) {
				break;
			}
		}
//		System.out.println();
		System.out.println(i);
	}

}

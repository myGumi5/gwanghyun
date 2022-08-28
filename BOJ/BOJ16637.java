import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BOJ16637 {
	static int N;
	static char[] c;
	static boolean[] v;
	static int res = Integer.MIN_VALUE;
	static int cal(int n1,int n2, char cs) {
		if(cs == '+') {
			return n1+n2;
		}
		if(cs == '-') {
			return n1-n2;
		}
		if(cs == '*') {
			return n1*n2;
		}
		if(cs == '/') {
			return n1/n2;
		}
		return 0;
	}
	static void dfs(int n, int ans) {
		if(n >= N) {
			res = Math.max(ans, res);
		} else {
			dfs(n+2,cal(ans,c[n+1]-'0',c[n]));
			if(n+2<N) {
				int sum = cal(c[n+1]-'0',c[n+3]-'0',c[n+2]);
				dfs(n+4,cal(ans,sum,c[n]));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		c = new char[N];
		v = new boolean[N];
		String str = sc.next();
		for(int i=0;i<str.length();i++) {
			c[i] = str.charAt(i);
		}
		dfs(1,c[0]-'0');
		System.out.println(res);
	}

}

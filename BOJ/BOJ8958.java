import java.util.Scanner;

public class BOJ8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			String str = sc.next();
			char[] c = str.toCharArray();
			int cnt = 0;
			int ans = 0;
			for(int j =0;j<c.length;j++) {
				if(c[j]=='O') {
					cnt++;
				} else {
					cnt = 0;
				}
				ans += cnt;
			}
			System.out.println(ans);
		}
	}
}

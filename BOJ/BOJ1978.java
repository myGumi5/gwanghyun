import java.util.Scanner;

public class BOJ1978 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		ss:for(int i = 0; i < N;i++) {
			int tmp = sc.nextInt();
			int pre = 1;
			if(tmp == 1)
				continue;
			for(int j = 2; j<=tmp;j++) {
				if(tmp%j==0) {
					pre++;
					if(pre == 3) {
						continue ss;
					}
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}

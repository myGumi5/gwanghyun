import java.util.Arrays;
import java.util.Scanner;

class foo{
	int x;
	foo(int x) {
		this.x = x;
	}
}

public class BJ1024 {
	
	static foo s (foo f) {
		f = new foo(100);
		return f;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] aa = {1,2,3,4,5};
		for(int x : aa) {
			x+=10;
		}
		System.out.printf("%.1f",(double)(7/3));
		int N = sc.nextInt();
		int L = sc.nextInt();
		int a = N/L;
		int start = 0;
		int c =0;
		int ans = -1;
		while(L<= 100) {
			start = a-c;
			if(start <0) break;
			int sum = start;
			for(int i =1;i<L;i++) {
				sum += (start+i);
			}
			if(sum>N) {
				c++;
				
			} else if(sum==N) {
				ans = start;
				break;
			} else {
				a = N/(++L);
				c = 0;
			}
		}
		if(ans == -1 || L >100) {
			System.out.println(-1);
			return;
		} else {
			for(int i =0;i<L;i++) {
				System.out.printf((start+i)+" ");
			}
		}
	}
}

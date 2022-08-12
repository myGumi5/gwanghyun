import java.util.Scanner;

public class BOJ2961 {
	
	static int[][] food;
	static int N,min = Integer.MAX_VALUE;
	static void f(int index, int a, int b) {
		if(index == N+1) {
			return;
		} else {
			if(index != 0) {
				a = a*food[index][0];
				b = b+food[index][1];
				min = Math.min(min, Math.abs(a-b));
			}
			for(int i = index;i<=N;i++) {
				f(i+1,a,b);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		food = new int[N+1][2];
		
		for(int i =1;i<=N;i++) {
			food[i][0] =sc.nextInt();
			food[i][1] =sc.nextInt();
		}
		f(0,1,0);
		System.out.println(min);
	}

}

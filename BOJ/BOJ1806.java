import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ1806 {

	public static void main(String[] args) {
		FastIn sc = new FastIn();
		int N = sc.nextInt();
		int S = sc.nextInt();
		int ans = Integer.MAX_VALUE;
		int[] box = new int[N+1];

		for (int i = 1; i <= N; i++) {
			box[i] =  sc.nextInt();
			
		}
		int s = 1, e = 1;
		int sum = 0;
		while(true) {
//			System.out.println(s + " " +e + " sum = " + sum);
			if(sum <S) {
				if(e == N+1)
					break;
				sum +=box[e++];
			} else {
				ans = Math.min(e-s, ans);
				sum -=box[s++];
			}
		}
		if( ans == Integer.MAX_VALUE)
			ans = 0 ;
		System.out.println(ans);
	}
	static class FastIn{
		BufferedReader br;
		StringTokenizer st;
		
		public FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String read() {
			while(st==null||!st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(read());
		}
		public String next() {
			return read();
		}
	}

}

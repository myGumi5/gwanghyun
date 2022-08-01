import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1914 {

	static ArrayList<Integer>[] list = new ArrayList[2];  
	public static void hanoi(int N, int start, int by ,int end) {
		if (N==1) {
			list[0].add(start);
			list[1].add(end);
			return;
		} else {
			hanoi(N-1,start,end,by);
			list[0].add(start);
			list[1].add(end);
			hanoi(N-1,by,start,end);
		}
	}
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		list[0] = new ArrayList<Integer>();
		list[1] = new ArrayList<Integer>();
		int N = sc.nextInt();
		if(N <= 20) {
			hanoi(N,1,2,3);
			System.out.println((long)Math.pow(2, N)-1);
			for(int i =0; i<list[0].size();i++)
				System.out.println(list[0].get(i) + " " + list[1].get(i));
		} else {
			BigInteger s = new BigInteger("1");
			for(int i = 0; i<N;i++) {
				s = s.multiply(new BigInteger("2"));
			}
			s = s.subtract(new BigInteger("1"));
			System.out.println(s);
		}
	}
	
	static class FastIn {
		BufferedReader br;
		StringTokenizer st;

		public FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {

			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}

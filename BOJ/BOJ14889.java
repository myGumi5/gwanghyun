import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14889 {

	static int N;
	static int[][] s;
	static int ans = Integer.MAX_VALUE;
	
	static void run(int index,int n, int flag) {
		if(n == N/2) {
			int tmp1=0,tmp2=0;
			List<Integer> a = new ArrayList<>();
			List<Integer> b = new ArrayList<>();
			for(int i = 0; i <N-1;i++) {
				for(int j = i+1;j<N;j++) {
					if((flag & 1<<i) >0 && (flag & 1<<j) >0) {
						tmp1+= s[i][j] + s[j][i];
					} else if((flag & 1<<i) ==0 && (flag & 1<<j) ==0) {
						tmp2+= s[i][j] + s[j][i];
					} 
				}
			}
			ans = Math.min(ans, Math.abs(tmp2-tmp1));
		} else {
			for(int i =index;i<N-(N/2-n);i++) {
				if((flag & 1<<i) ==0)
					run(i+1,n+1,flag | 1<<i);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastIn sc = new FastIn();

		ans = Integer.MAX_VALUE;
		N = sc.nextInt();
		s = new int[N][N];
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				s[i][j] = sc.nextInt();
			}				
		}
		run(0,0,0);
		System.out.println(ans);
		
	}
	static class FastIn{
		BufferedReader br;
		StringTokenizer st;
		FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st==null||!st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}

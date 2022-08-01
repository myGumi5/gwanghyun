import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ11404 {

	public static void main(String[] args) {
		FastIo sc = new FastIo();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] box = new int[N+1][N+1];
		
		for(int i =1; i<=N;i++) {
			for(int j =1; j<=N;j++) {
				box[i][j] = 10000001;//10000001
			}
		}
		
		for(int i=1;i<=M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			box[a][b] = Math.min(box[a][b], c);
		}
		
		for(int k = 1;k<=N;k++) {
			for(int i =1; i<=N;i++) {
				if (k==i) 
					continue;
				for(int j =1; j<=N;j++) {
					if (i==j)
						box[i][j] = 0;
					else
						box[i][j] = Math.min(box[i][k]+ box[k][j],box[i][j]);
				}
			}
		}
		for(int i =1; i<=N;i++) {
			for(int j =1; j<=N;j++) {
				if(box[i][j] == 10000001) {
					box[i][j] = 0;
				}
				System.out.print(box[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	static class FastIo {
		BufferedReader br;
		StringTokenizer st;
		FastIo() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null||!st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
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

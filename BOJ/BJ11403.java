import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ11403 {

	public static void main(String[] args) {
		FastIo sc = new FastIo();
		int N = sc.nextInt();
		int[][] box = new int[N][N];
		
		
		for(int i =0; i<N;i++) 
			for(int j =0; j<N;j++) 
				box[i][j] = sc.nextInt();
		
		
		for(int k = 0;k<N;k++) {
			for(int i =0; i<N;i++) {
				for(int j =0; j<N;j++) {
					if(box[i][k] + box[k][j] == 2) 
						box[i][j] = 1;
				}
			}
		}
		
		for(int i =0; i<N;i++) {
			for(int j =0; j<N;j++) {
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

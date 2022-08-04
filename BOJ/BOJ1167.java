import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1167 {

	
	public static void main(String[] args) {
		FastIn fi = new FastIn();
		int N = fi.nextInt();
		int r = fi.nextInt();
		int c = fi.nextInt();
		
		int curN = N;
		
		
		int x = (int)Math.pow(2, N)* (int)Math.pow(2, N) - 1;
		int y = (int)Math.pow(2, N)* (int)Math.pow(2, N) - 1;
		
		int p = (int)Math.pow(2, N)-1;
		while (true) {
			if(r <x/2) {
				curN--;
				p -= (int)Math.pow(2, curN); 
				x = x/2;
			}
			if(c<y) {
				p = p - (int)Math.pow(2, N);
				y = y/2;
			}
			if(x==r && y == c) {
				System.out.println(p);
				break;
			}
		}
				
	}

	static class FastIn{
		BufferedReader br = null;
		StringTokenizer st = null;
		FastIn(){
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

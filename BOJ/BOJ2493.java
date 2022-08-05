import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Signal{
	int pos;
	int val;
	public Signal(int pos, int val) {
		super();
		this.pos = pos;
		this.val = val;
	}
	
}

public class BOJ2493 {

	static int N;
	static int[] tower,ans;
	static Stack<Signal> s = new Stack<>();
	public static void main(String[] args) {
		FastIo sc = new FastIo();
		N = sc.nextInt();
		tower = new int[N];
		ans = new int[N];
		for (int i = 0 ; i <N ; i++) {
			tower[i] = sc.nextInt();
		}
		for(int i=N-1;i>=0;i--) {
			while(true) {
				if(s.isEmpty())
					break;
				Signal tmp = s.peek();
				if(tower[i]>=tmp.val) {
					ans[tmp.pos] = i +1;
					s.pop();
				} else {
					break;
				}
			}
			s.add(new Signal(i,tower[i]));
		}
		for(int i =0;i<N;i++) {
			System.out.print(ans[i]+ " ");
			
		}
	}
	
	static class FastIo {
		BufferedReader br;
		StringTokenizer st;
		
		FastIo() {
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

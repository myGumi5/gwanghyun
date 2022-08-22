import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
	static int L, C;
	static char[] cs;
	static StringBuilder sb = new StringBuilder();
	static boolean[] v;
	static char[] ans;
	static boolean isVowel(char c) {
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
			return true;
		}
		return false;
	}
	static void dfs(int index, int n) {
		if(n==L) {
			int v=0 , r =0;
			StringBuilder tmp = new StringBuilder();
			for(int i = 0; i<n;i++) {
				if(isVowel(ans[i])) {
					v++;
				} else {
					r++;
				}
				tmp.append(ans[i]);
			}
			if(v >=1 && r>=2) {
				sb.append(tmp).append("\n");
			}
			return;
		}
		for(int i = index; i<C;i++) {
			ans[n] = cs[i];
			dfs(i+1,n+1);
		}
	}
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		
		L = sc.nextInt();
		C = sc.nextInt();
		cs = new char[C];
		v = new boolean[C];
		ans = new char[C];
		for(int i =0; i <C;i++) {
			cs[i] = sc.next().charAt(0);
		}
		Arrays.sort(cs);
		dfs(0,0);
		System.out.println(sb);
	}
	
	static class FastIn {
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

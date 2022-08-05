import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ12891 {

	static char[] c = null;
	static boolean[] b  = null;
	static int ans = 0;
	static int S, P;
	static Map<Character, Integer> DNA = new HashMap<>();
	static Map<Character, Integer> tmp = new HashMap<>();
//	public static void powerSet(int cnt, int n) {
//		if(cnt == n+1) {
//			for(int i =0;i<4;i++) {
//				if(DNA[i]>tmp[i])
//					return;
//			}
//			ans++;
//		} else {
//			b[cnt] = true;
//			if(c[cnt]=='A') {
//				tmp[0]++;
//			}
//			if(c[cnt]=='C') {
//				tmp[1]++;
//			}
//			if(c[cnt]=='G') {
//				tmp[2]++;
//			}
//			if(c[cnt]=='T') {
//				tmp[3]++;
//			}
//			powerSet(cnt+1,n);
//			if(c[cnt]=='A') {
//				tmp[0]--;
//			}
//			if(c[cnt]=='C') {
//				tmp[1]--;
//			}
//			if(c[cnt]=='G') {
//				tmp[2]--;
//			}
//			if(c[cnt]=='T') {
//				tmp[3]--;
//			}
//			powerSet(cnt+1,n);
//		}
//	}
	
	public static void main(String[] args) {
		FastIo sc = new FastIo();
		boolean flag = true;
		S = sc.nextInt();
		P = sc.nextInt();
		c = sc.next().toCharArray();
		
		DNA.put('A', sc.nextInt());
		DNA.put('C', sc.nextInt());
		DNA.put('G', sc.nextInt());
		DNA.put('T', sc.nextInt());
		tmp.put('A', 0);
		tmp.put('C', 0);
		tmp.put('G', 0);
		tmp.put('T', 0);
		for(int i =0;i<P;i++) {
			tmp.put(c[i], tmp.get(c[i]) + 1);
		}
		for(char key : tmp.keySet()) {
			if(tmp.get(key) <DNA.get(key)) {
				flag = false;
				break;
			}
		}
		if(flag)
			ans++;
		
		for(int i = P;i<S;i++) {
			flag = true;
			tmp.put(c[i-P], tmp.get(c[i-P]) - 1);
			tmp.put(c[i], tmp.get(c[i]) + 1);
			
			for(char key : tmp.keySet()) {
				if(tmp.get(key) <DNA.get(key)) {
					flag = false;
					break;
				}
			}
			if(flag)
				ans++;
		}
		System.out.println(ans);
		
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

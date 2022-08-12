import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
/*
 * 
6
2 1 2 0 3 1 // 검
1 2 2 2 2 0 // 회
1 0 1 2 0 3 // 흰
2
2 4
 * 
 * */
public class BOJ11723 {
	static Set<Integer> s = new HashSet<>();
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		for(int i =0;i<N;i++) {
			String cmd = sc.next();
			switch(cmd) {
			case "add":
				s.add(sc.nextInt());
				break;
			case "toggle":
				int tmp = sc.nextInt();
				if(s.contains(tmp)) {
					s.remove(tmp);
				} else {
					s.add(tmp);
				}
				break;
			case "remove":
				s.remove(sc.nextInt());
				break;
			case "empty":
				s.clear();
				break;
			case "check":
				if(s.contains(sc.nextInt()))
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			case "all":
				for(int j = 1; j <= 20;j++) {
					s.add(j);
				}
				break;
			}
		}
		System.out.println(sb);
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

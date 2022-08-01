import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1461 {
	public static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int point = 0;
		int ans = 0;
		for(int i =0;i<N;i++) {
			int num = sc.nextInt();
			list.add(num);
		}
		list.add(0);
		list.sort((o1,o2) -> o1-o2);
		for(int i =0;i<list.size();i++) {
			if(list.get(i) == 0) {
				point = i;
				break;
			}
		}
		for(int i = 0; i<point; i +=M) {
			ans += Math.abs(list.get(i)) * 2;
		}
		for(int i = list.size()-1; i>point; i -=M) {
			ans += Math.abs(list.get(i)) * 2;
		}
		
		System.out.println(ans-Math.max(Math.abs(list.get(0)), Math.abs(list.get(N))));
	}
	static class FastIn {
		BufferedReader br;
		StringTokenizer st;
		
		public FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			
			while(st ==null||!st.hasMoreElements()) {
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ11724 {
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
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] v = new boolean[N+1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 0 ; i <N+1;i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0 ; i <M;i++) {
			int u = sc.nextInt();
			int vv = sc.nextInt();
			list.get(u).add(vv);
			list.get(vv).add(u);
		}
		int cnt = 0;
		for(int i = 1; i<=N;i++) {
			if(v[i]) continue;
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			while(!q.isEmpty()) {
				int tmp = q.poll();
				for(Integer a : list.get(tmp)) {
					if(v[a]) continue;
					v[a] =true;
					q.add(a);
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ2606_DFS {
	static Map<Integer, ArrayList<Integer>> list=new HashMap<>();
	static boolean[] visited = null;
	static int ans = 0;
	public static void dfs(int k) {
		if (visited[k])
			return;
		if(k != 1)
			ans++;
		visited[k] = true;
		for(int i : list.get(k)) {
			dfs(i);
		}
	}
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int root = 1;
		for(int i =1;i<=N;i++) {
			list.put(i, new ArrayList<Integer>());
		}
		visited = new boolean[N+1];
		for(int i =0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		dfs(1);
		System.out.println(ans);
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

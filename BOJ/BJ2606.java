import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ2606 {
	static int[] parent=null;
	public static int find(int a) {
    	if(parent[a] == a)
    		return a;
    	else
    		return parent[a] = find(parent[a]);
    }
	
	public static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if(a != b)
    		parent[b] = a;
    }
	
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		parent = new int[N+1];
		for(int i = 1;i<=N;i++)
			parent[i] = i;
		
		int ans = 0;
		for(int i =0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a,b);
		}
		int x = find(1);
		
		for(int i =2;i<=N;i++) {
			if(find(i) == x)
				ans ++;
		}
		
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

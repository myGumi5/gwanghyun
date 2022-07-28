import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1991 {
	static Map<String,String[]> tree = new HashMap<>();
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			tree.put(sc.next(), new String[]{sc.next(),sc.next()});
		}
		preorder("A");
		System.out.println();
		inorder("A");
		System.out.println();
		postorder("A");
		System.out.println();
	}
	
	public static void preorder(String alpha) {
		if(tree.get(alpha) == null) {
			return;
		}
		System.out.print(alpha);
		preorder(tree.get(alpha)[0]);
		preorder(tree.get(alpha)[1]);
		
	}
	public static void inorder(String alpha) {
		if(tree.get(alpha) == null) {
			return;
		}
		inorder(tree.get(alpha)[0]);
		System.out.print(alpha);
		inorder(tree.get(alpha)[1]);
		
	}
	
	public static void postorder(String alpha) {
		if(tree.get(alpha) == null) {
			return;
		}
		postorder(tree.get(alpha)[0]);
		postorder(tree.get(alpha)[1]);
		System.out.print(alpha);
		
		
	}
	static class FastIn{
		BufferedReader br;
		StringTokenizer st;
		
		public FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String read() {
			while(st==null||!st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(read());
		}
		public String next() {
			return read();
		}
	}
}

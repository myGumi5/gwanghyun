import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ5052 {
	
	static class Trie {
		boolean isEnd;
		Trie[] child;
		Trie() {
			isEnd = false;
			child = new Trie[10];
			for(int i = 0 ; i < 10;i ++) {
				child[i] = null;
			}
		}
		public boolean isEnd() {
			return isEnd;
		}
		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}
		public Trie[] getChild() {
			return child;
		}
		public void setChild(Trie[] child) {
			this.child = child;
		}
		
	}
	static void insert(String key) {
		Trie cur = root;
		for(int i = 0; i < key.length();i++) {
			int idx = key.charAt(i) - '0';
			if(cur.getChild()[idx] == null) {
				cur.getChild()[idx] = new Trie();
			}
			cur = cur.getChild()[idx];
		}
		cur.setEnd(true);
	}
	
	static boolean avilable(String key) {
		boolean flag = true;
		Trie cur = root;
		for(int i = 0; i<key.length()-1;i++) {
			int idx = key.charAt(i) - '0';
			if(cur.getChild()[idx].isEnd()) {
				flag = false;
				break;
			}
			cur = cur.getChild()[idx];
		}
		
		return flag;
	}
	
	
	static Trie root;
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
	
		int T = sc.nextInt();
		for(int t = 1; t <=T ;t++) {
			int N = sc.nextInt();
			root = new Trie();
			String[] str = new String[N];
			for(int i = 0; i <N;i++) {
				str[i] = sc.next();
				insert(str[i]);
			}
			boolean ans = true;
			for(int i = 0;i<N;i++) {
				if(!avilable(str[i])) {
					ans = false;
					break;
				}
			}
			if(ans )
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
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

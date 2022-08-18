import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ19585 {
	static class Trie{
		boolean isEnd;
		Trie[] child;
		
		Trie() {
			isEnd=false;
			child = new Trie[27];
			for(int i =0;i<27;i++) {
				child[i] = null;
			}
		}
	}
	
	static void insert(String key) {
		Trie cur = root;
		for(int i = 0; i<key.length();i++) {
			int k = key.charAt(i)-'a';
			if(cur.child[k] == null) {
				cur.child[k] = new Trie();
			}
			cur = cur.child[k];
		}
		cur.isEnd = true;
	}
	static boolean available(String key) {
		Trie cur = root;
		for(int i = 0; i<key.length();i++) {
			int k = key.charAt(i)-'a';
			cur = cur.child[k];
			if(cur == null) {
				return false;
			}
			if(cur.isEnd) {
				if(s.contains(key.substring(i+1)))
					return true;
			}
		}
		return false;
	}
	static Trie root;
	static Set<String> s = new HashSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastIn sc = new FastIn();
		root = new Trie();
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] color = new String[N];
		String[] nick = new String[M];
		for(int i = 0; i <N;i++) {
			color[i] = sc.next();
			insert(color[i]);
		}
		for(int i = 0; i <M;i++) {
			nick[i] = sc.next();
			s.add(nick[i]);
		}
		StringBuilder sb = new StringBuilder();
		int Q = sc.nextInt();
		for(int q = 0; q<Q;q++) {
			
			if(available(sc.next()))
				sb.append("Yes").append("\n");
			else 
				sb.append("No").append("\n");
		}
		System.out.print(sb);
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

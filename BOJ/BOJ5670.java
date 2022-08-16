import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BOJ5670 {
	
	static class Trie {
		boolean isEnd;
		int count;
		Trie[] child;
		Trie() {
			isEnd = false;
			child = new Trie[27];
			count = 0;
			for(int i = 0 ; i < 27;i ++) {
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
			int idx = key.charAt(i) - 'a';
			if(cur.getChild()[idx] == null) {
				cur.getChild()[idx] = new Trie();
				cur.count++;
			}
			cur = cur.getChild()[idx];
		}
		cur.setEnd(true);
	}
	
	static int avilable(String key) {
		Trie cur = root;
		int cnt = 0;
		for(int i = 0; i<key.length();i++) {
			int idx = key.charAt(i) - 'a';
			if(cur.getChild()[idx].count != 1) {
				cnt++;
			} else if(cur.getChild()[idx].isEnd) {
				cnt++;
			}
			cur = cur.getChild()[idx];
		}
		return cnt;
	}
	
	
	static Trie root;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int N = sc.nextInt();
			root = new Trie();
			String[] str = new String[N];
			for(int i = 0; i <N;i++) {
				str[i] = sc.next();
				insert(str[i]);
			}
			int ans = 0;
			for(int i = 0;i<N;i++) {
				ans += avilable(str[i]);
			}
			
			System.out.printf("%.2f%n",(float)ans/N);
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

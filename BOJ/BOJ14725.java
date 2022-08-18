<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BOJ14725 {
	
	static class Trie {
		Map<String,Trie> child;
		boolean isEnd;
		int depth;
		Trie() {
			child = new HashMap<>();
			isEnd = false;
		}
		
	}
	
	static void insert(String key) {
		Trie cur = root;
		for(int i = 0; i<key.length();i++) {
			if(cur.child.get(key) == null) {
				cur.child.put(key, new Trie());
			}
			int d = cur.depth+1;
			cur = cur.child.get(key);
			cur.depth = d;
		}
		cur.isEnd = true;
	}
	static Trie root;
	
	static void pr(Trie cur) {
		if(cur == null || cur.child.size() == 0) {
			return;
		} else {
			Object[] keys = cur.child.keySet().toArray();
			Arrays.sort(keys);
			for(Object s : keys) {
				for(int i = 0 ; i<cur.depth;i++) 
					System.out.print("--");
				System.out.println(String.valueOf(s));
				pr(cur.child.get(String.valueOf(s)));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		root = new Trie();
		root.depth = 0;
		
		int N = sc.nextInt(); 
		
		for(int i = 0;i<N;i++) {
			int M = sc.nextInt();
			Trie cur = root;
			for(int j=0;j<M;j++) {
				String key = sc.next();
				if(cur.child.get(key) == null) {
					cur.child.put(key, new Trie());
				}
				int d = cur.depth+1;
				cur = cur.child.get(key);
				cur.depth = d;
			}
			cur.isEnd = true;
		}
		pr(root);
=======

public class BOJ14725 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

>>>>>>> 7575c434bdda1e678236eb93d04d712975608ca6
	}

}

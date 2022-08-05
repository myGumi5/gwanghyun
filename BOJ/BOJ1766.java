import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1766 {

	static ArrayList<PriorityQueue<Integer>> tree = new ArrayList<PriorityQueue<Integer>>();
	public static void main(String[] args) {
		FastIo fi = new FastIo();
		int N = fi.nextInt();
		int M = fi.nextInt();
		int[] depth = new int[N+1];
		for (int i = 0; i<=N ; i++)
			tree.add(new PriorityQueue<Integer>());
		for(int i = 0; i<M;i++) {
			int a = fi.nextInt();
			int b = fi.nextInt();
			depth[b]++;
			tree.get(a).add(b);
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i =1;i<=N;i++) {
			if(depth[i] ==0)
				q.add(i);
		}
		
		while(!q.isEmpty()) {
			int index = q.poll();
			System.out.print(index + " ");
			PriorityQueue<Integer> tmp = new PriorityQueue<Integer>();
			int size = tree.get(index).size();
			for(int i = 0; i<size; i++) {
				int x = tree.get(index).poll();
				tmp.add(x);
				if(--depth[x] == 0) {
					q.add(x);
				}
			}
			tree.set(index, tmp);
			
		}
	}
	
	static class FastIo{
		BufferedReader br;
		StringTokenizer st;
		FastIo() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st ==null||!st.hasMoreElements()) {
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

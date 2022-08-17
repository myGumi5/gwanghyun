import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1516 {

	public static void main(String[] args) {
		FastIn sc = new FastIn();
		int N = sc.nextInt();
		ArrayList<ArrayList<Integer>> s = new ArrayList<>();
		int[] box = new int[N+1];
		int[] polo = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		for(int i =0 ; i<=N;i++)
			s.add(new ArrayList<>());
		for(int i = 1; i<=N ; i++) {
			box[i] = sc.nextInt();
			int ss = 0;
			while ((ss = sc.nextInt())!=-1) {
				polo[i]++;
				s.get(ss).add(i);
			}
			if(polo[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int index : s.get(tmp)) {
				if(--polo[index]==0) {
					q.add(index);
					box[index] += box[tmp];
				}
			}
			System.out.println(box[tmp]);
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

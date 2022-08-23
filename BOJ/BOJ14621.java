import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ14621 {
	static int N,M,A,B,C;
	static int[] p;
	static boolean[] isM;
	
	static class Node implements Comparable<Node>{
		int s, e;
		int v;
		
		public Node(int s, int e, int v) {
			super();
			this.s = s;
			this.e = e;
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.v, o.v);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		p = new int[N+1];
		isM = new boolean[N+1];
		List<Node> n = new LinkedList<>();
		for(int i = 1; i<N+1;i++) {
			if(sc.next().charAt(0) == 'M')
				isM[i] = true;
			p[i] = i;
		}
		
		for(int i = 0; i<M;i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();
			if(isM[A] != isM[B]) {
				n.add(new Node(A,B,C));
			}
		}
		Collections.sort(n);
		int sum = 0;
		int cnt = 0;
		for(Node now : n) {
			int s = now.s;
			int e = now.e;
		
			if(union(s,e)) {
				cnt++;
				sum += now.v;
			}
			if(cnt == N-1) {
				break;
			}
			
		}
		if(sum == 0 || cnt != N-1)
			sum = -1;
		System.out.println(sum);
	}

	private static boolean union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a==b) {
			return false;
		}
		p[b] = a;
		return true;
	}

	private static int findSet(int a) {
		if(p[a]==a) {
			return a;
		}
		return p[a]=findSet(p[a]);
	}

}

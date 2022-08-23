import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ1043 {
	static int[] p;
	static boolean[] c;
	static int N,M;
	static Set<Integer> s ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int T = sc.nextInt();
		s = new HashSet<>();
		int[] a = new int[M];
		p = new int[N+1];
		for(int i = 1;i<=N;i++) {
			p[i] = i;
		}
		for(int t = 0;t<T;t++) {
			s.add(sc.nextInt());
		}
		for(int m = 0 ; m<M;m++) {
			int K = sc.nextInt();
			int[] tmp = new int[K];
			for(int k = 0; k<K;k++) {
				tmp[k] = sc.nextInt();
			}
			a[m] = tmp[0];
			if(tmp.length >1) {
				for(int i = 0; i<tmp.length-1;i++) {
					union(tmp[i],tmp[i+1]);
				}
			}
		}
		int ans = 0;
		for(int i = 0; i<M;i++) {
			if(!s.contains(findSet(a[i]))) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	static void union(int a , int b) {
		a = findSet(a);
		b = findSet(b);
		if(a==b) {
			return;
		}
		if(s.contains(b) || s.contains(a)) {
			s.add(a);
			s.add(b);
		}
		p[b] = a;
	}
	static int findSet(int a) {
		if(p[a] == a) {
			return a;
		}
		if(s.contains(a)) {
			s.add(p[a]);
		}
		return p[a] = findSet(p[a]);
	}
}

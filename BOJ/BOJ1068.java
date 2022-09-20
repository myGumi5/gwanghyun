import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1068 {

	
	static int[] arr;
	static ArrayList<Integer>[] list;
	static int N,root,target;
	static boolean[] v;
	static int a=0,b=0,cnt = 0;
	static void dfs(int n) {
		if(list[n].size()==0) {
			cnt++;
		} else {
			for(int tmp : list[n]) {
				if(!v[tmp]) {
					v[tmp] = true;
					dfs(tmp);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		root = 0;
		list = new ArrayList[N];
		for(int i = 0 ; i< N;i++) {
			list[i] = new ArrayList<>();
		}
		// 트리를 연결한다.
		for(int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			if(tmp == -1) {
				root = i;
			} else {
				list[tmp].add(i);
			}
		} 
		target = sc.nextInt(); 
		if(root != target) {
			v = new boolean[N];
			dfs(root);
			a= cnt;
			cnt = 0;
			v = new boolean[N];
			dfs(target);
			b = cnt;
		}
		System.out.println(a-b);
	}

}

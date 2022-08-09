import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i =1;i<=N;i++) {
			q.add(i);
		}
		System.out.print("<");
		while(!q.isEmpty()) {
			for(int i = 0 ;i<K-1;i++) {
				int a = q.poll();
				q.add(a);
			}
			System.out.print(q.poll());
			if(q.isEmpty())
			System.out.print(">");
			else
				System.out.print(", ");
			
		}
		
	}

}

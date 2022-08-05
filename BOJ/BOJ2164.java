import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		int N = sc.nextInt();
		
		for (int i = 1; i<=N;i++) {
			q.add(i);
		}
		
		while(q.size()>1) {
			q.remove(); //최상단 제거 (null일시 예외 발생)
			int num = q.poll(); // 최상단 제거  (null일시 null 반환)
			q.add(num);
		}
		System.out.println(q.poll());
		
	}

}

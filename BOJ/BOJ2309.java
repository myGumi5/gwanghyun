import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ2309 {

	static int[] p = new int[9];
	static boolean pp[] = new boolean[9];
	static List<Integer> answer = new ArrayList<>();
	
	static void powerSet (int cnt,int n) {
		
		if(answer.size()==7) 
			return;
		if(cnt == 9) {
			int sum = 0;
			for(int i = 0; i <9;i++) {
				if(pp[i])
					sum += p[i];
			}
			if (sum == 100) {
				for(int i = 0; i <9;i++) {
					if(pp[i]) {
						answer.add(p[i]);
					}
				}
				if(answer.size()!=7) 
					answer.clear();
			}
			return;
		}
		pp[cnt] = true;
		powerSet(cnt+1, n);
		pp[cnt] = false;
		powerSet(cnt+1, n);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ;i <9;i++) {
			p[i] = sc.nextInt();
		}
		powerSet(0,7);
		answer.sort((o1,o2) -> o1-o2);
		for(int i = 0; i<7;i++) {
			System.out.println(answer.get(i));
		}
	}

}

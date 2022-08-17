import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ3040 {

	static int[] p = new int[9];

	static List<Integer> answer = new ArrayList<>();
	
	static void powerSet (int cnt,int n,int check) { // 멱집합 활용 
		if(answer.size()==7) // 7개를 뽑았으면 탐색 종료 
			return;
		if(cnt == 9) {
			int sum = 0;
			for(int i = 0; i <9;i++) {
				if((check & (1<<i)) > 0) // 비트 마스킹으로 방문체크 
					sum += p[i];
			}
			if (sum == 100) {
				for(int i = 0; i <9;i++) {
					if((check & (1<<i))>0) { // 방문체크 
						answer.add(p[i]);
					}
				}
				if(answer.size()!=7) // 7난쟁이가 아닌 수로 100이 됐을경우 탐색 종료 
					answer.clear();
			}
			return;
		}
		powerSet(cnt+1, n, check | (1<<cnt));
		powerSet(cnt+1, n,check);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ;i <9;i++) {
			p[i] = sc.nextInt();
		}
		powerSet(0,7,0);
		for(int i = 0; i<7;i++) {
			System.out.println(answer.get(i));
		}
	}

}
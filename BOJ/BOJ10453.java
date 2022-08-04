import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ10453 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i<N;i++) {
			char[] s1 = sc.next().toCharArray();
			char[] s2 = sc.next().toCharArray();
			ArrayList<Integer> a1 = new ArrayList<>();
			ArrayList<Integer> a2 = new ArrayList<>();
			for(int j = 0; j<s1.length;j++) {
				if(s1[j] =='a')
					a1.add(j);
				if(s2[j] =='a')
					a2.add(j);
			}
			int ans = 0;
			for(int j = 0;j<a1.size();j++) {
				ans += Math.abs(a1.get(j) - a2.get(j));
			}
			System.out.println(ans);
		}
		
		
	}
}

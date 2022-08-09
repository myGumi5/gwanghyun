import java.util.Scanner;
import java.util.Stack;

public class SWEA5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1;t<=T;t++) {
			Stack<Character> s = new Stack<>();
			int ans = 0;
			char[] c = sc.next().toCharArray();
			char prev = '(';
			for(int i =0;i<c.length;i++) {
				if(c[i] == '(') {
					s.push(c[i]);
				} else {
					s.pop();
					if(prev == ')'){
						ans++;
						continue;
					}
					ans += s.size();
				}
				prev = c[i];
			}
			System.out.println("#"+t+" "+ans);
		}
		
	}

}

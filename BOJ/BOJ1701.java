import java.util.Scanner;

public class BOJ1701 {
	static int pi(String str) {
		int j = 0;
		int max = 0;
		int[] pi = new int[str.length()];
		for(int i = 1; i<str.length();i++) {
			while(j>0 && str.charAt(i) != str.charAt(j)) {
				j = pi[j-1];
			}
			if(str.charAt(i) == str.charAt(j)) {
				pi[i] = ++j;
				max = Math.max(pi[i], max);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int max = 0;
		for(int i = 0 ; i< str.length();i++) {
			max = Math.max(max, pi(str.substring(i)));
		}
		System.out.println(max);
	}

}

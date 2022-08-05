import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2023 {
	public static Boolean isPrime(int n) {
		for (int i = 2; i<=(int)Math.sqrt(n); i++) {
	      if (n % i == 0) {
	          return false;
	      }
		}
		return true;
	}
	
	public static void backTracking(String num) {
		if(num.length() == N) {
			int n = Integer.parseInt(num);
			if(isPrime(Integer.parseInt(num))) {
				list.add(n);
			}
		} else {
			for(int i = 0; i<10;i++) {
				String newstr = num.concat(String.valueOf(i));
				if(isPrime(Integer.parseInt(num))) {
					backTracking(newstr);
				}
			}
		}
	}
	static int N;
	static List<Integer> list =new ArrayList<>();;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i = 2;i<=9;i++)
			if(isPrime(i))
				backTracking(String.valueOf(i));
		list.sort((o1,o2)->o1-o2);
		for(int a : list) {
			System.out.println(a);
		}
	}

}

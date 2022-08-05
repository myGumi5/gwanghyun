import java.util.Arrays;
import java.util.Scanner;

public class BOJ14891 {
	static char[][] gear = new char[4][];
	static int[] direction = new int[4];
	static Scanner sc = null;

	public static void main(String[] args) {
		init();
		run();
		pr();
	}

	static void init() {
		sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			gear[i] = sc.next().toCharArray();
		}
	}

	static void run() {
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			direction = new int[4];
			int num = sc.nextInt();
			int dir = sc.nextInt();
			spin(num-1,dir);
			doitAll();
		}
	}
	static void pr() {
		int ans = 0;
		
		if(gear[0][0] == '1') {
			ans +=1;
		}
		if(gear[1][0] == '1') {
			ans +=2;
		}
		if(gear[2][0] == '1') {
			ans +=4;
		}
		if(gear[3][0] == '1') {
			ans +=8;
		}
		System.out.println(ans);
	}
	static void spin(int num, int dir) {
		direction[num] = dir;
		for(int i = num - 1; i >= 0; i--) {
			if(gear[i+1][6] == gear[i][2]) {
				break;
			}
			direction[i] = -direction[i+1];
		}
		
		for(int i = num + 1; i <= 3; i++) {
			if(gear[i-1][2] == gear[i][6]) {
				break;
			}
			direction[i] = -direction[i-1];
		}
	}
	
	static void doitAll() {
		for(int i = 0; i < 4; i++) {
			if(direction[i] == 1) {
				clock(i);
			} else if(direction[i] == -1) {
				reverseClock(i);
			}
		}
	}
	
	static void clock(int index) {
		String str = new String(gear[index]);
		String tmp = String.valueOf(gear[index][7]);
		str = str.substring(0,str.length()-1);
		str = tmp.concat(str);
		gear[index] = str.toCharArray();
	}
	
	static void reverseClock(int index) {
		String str = new String(gear[index]);
		str = str.substring(1,str.length());
		str = str.concat(String.valueOf(gear[index][0]));
		gear[index] = str.toCharArray();
	}
}

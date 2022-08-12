import java.util.Arrays;
import java.util.Scanner;

public class BOJ2470 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] box = new int[N];
		int s = 0, e  = N-1;
		for(int i = 0; i < N;i++) {
			box[i] = sc.nextInt();
		}
		Arrays.sort(box);
		int min = Integer.MAX_VALUE;
		int tmp_s = 0;
		int tmp_e = N-1;
		while(s<e) {
			int tmp = box[s] + box[e];
			if(Math.abs(tmp)<=min) {
				min = Math.abs(tmp);
				tmp_s = box[s];
				tmp_e = box[e];
				if(Math.abs(box[s]) < Math.abs(box[e])) {
					e--;
				} else {
					s++;
				}
			} else {
				s++;
			}
		}
		System.out.print(tmp_s+" "+tmp_e);
	}

}

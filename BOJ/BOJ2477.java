import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ2477 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int w=0,h=0;
		int sw=500,sh=500;
		int[] aa = new int[6];
		for(int i = 0; i <6;i++) {
			int d = sc.nextInt();
			int tmp = sc.nextInt();
			aa[i] = tmp;
			if(d == 1||d == 2) {
				if(w < tmp) {
					w = tmp;
					sw = i;
				}
			} else {
				if(h < tmp) {
					h = tmp;
					sh = i;
				}
			}
		}
		int tmp = 0;
		int tw = 0, th = 0,tw2 = 0, th2 = 0;
		if(sw+1 == 6) {
			th= 0;
		} else {
			th = sw+1;
		}
		if(sw-1==-1) {
			th2 = 5;
		} else {
			th2 = sw-1;
		}
		if(sh+1 == 6) {
			tw= 0;
		} else {
			tw = sh+1;
		}
		if(sh-1==-1) {
			tw2 = 5;
		} else {
			tw2 = sh-1;
		}
		tmp = Math.abs(aa[th]-aa[th2]) * Math.abs(aa[tw]-aa[tw2]);
		System.out.println((w*h-tmp)*N);
		
		
	}

}

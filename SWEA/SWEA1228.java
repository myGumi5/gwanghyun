import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA1228 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t<=10; t++) {
			int N = sc.nextInt();
			List<Integer> list = new LinkedList<>();
			for(int i = 0 ; i< N;i++) {
				list.add(sc.nextInt());
				
			}
			int M = sc.nextInt();
			for(int i = 0 ; i< M;i++) {
				sc.next();
				int x = sc.nextInt();
				int size = sc.nextInt();
				for(int j = 0; j<size ; j++) {
					list.add(x+j, sc.nextInt());
				}
			}
			System.out.print("#"+t+" ");
			int j = 0;
			for(int a : list) {
				if(j==10)
					break;
				System.out.print(a + " ");
				j++;
			}
			System.out.println();
		}
		
	}
}

import java.util.Scanner;

public class BOJ2920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int pre = sc.nextInt();
		int asc = 0;
		int des = 0;
		for(int i =1;i<8;i++) {
			int cur = sc.nextInt(); 
			if(pre<cur)
				asc++;
			else 
				des++;
			pre = cur;
		}
		if(asc == 7)
			System.out.println("ascending");
		else if(des == 7)
			System.out.println("descending");
		else
			System.out.println("mixed");

	}

}

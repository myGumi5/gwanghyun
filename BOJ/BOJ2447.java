import java.util.Scanner;

public class BOJ2447 {
	static char[][] box = null;
	static void pr(int x , int y, int N) {
		if(N==0) {
			return;
		} else {
			for(int i = x+N/3; i<x+N/3 * 2;i++) {
				for(int j = y+N/3; j<y+N/3 * 2;j++) {
					box[i][j] = ' ';
				}
			}
			int size = N /3 ;
			pr(x,y,size);
			pr(x,y+size,size);
			pr(x,y+size*2,size);
			pr(x+size,y,size);
			pr(x+size,y+size,size);
			pr(x+size,y+size*2,size);
			pr(x+size*2,y,size);
			pr(x+size*2,y+size,size);
			pr(x+size*2,y+size*2,size);

		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		box = new char[N][N]; 
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N;j++)
				box[i][j] = '*';
		pr(0,0,N);
		for(int i = 0; i < N; i++)
			System.out.println((new String(box[i])));

	}

}

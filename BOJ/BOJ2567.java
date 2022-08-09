import java.util.Scanner;

public class BOJ2567 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] box = new int[100][100];
		int ans = 0;
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int j = a;j<a+10;j++) {
				for(int k = b; k<b+10;k++) {
					box[j][k] = 1;
				}
			}
		}
//		for(int i = 0;i<100;i++) {
//			for(int j=0;j<100;j++) {
//				System.out.print(box[i][j] + " ");
//			}
//			System.out.println();
//		}
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		for(int i = 0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(box[i][j] == 1) {
					//System.out.println(i+ " "+j);
					for(int d = 0; d<4;d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if(nx<0||nx>=100||ny<0||ny>=100) {
							ans++;
							continue;
						} 
						if(box[nx][ny] == 0) {
							ans++;
							continue;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

}

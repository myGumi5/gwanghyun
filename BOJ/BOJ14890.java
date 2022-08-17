import java.util.Scanner;

public class BOJ14890 {
	static int N,L;
	static int[][] road;
	static int ans = 0;
	static void input() {
		
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		L=sc.nextInt();
		road = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				road[i][j] = sc.nextInt();
			}
		}
	}
	static void horrison() {
		for(int i =0;i<N;i++) {
			boolean check = true;
			//시작할때 처음 값을 미리 저장한다. 
			// 이전 값이 1보다 크면 return;
			int prev = road[i][0];
			int cnt = 1;
			boolean[] v = new boolean[N];
			boolean left = false;
			for(int j =1;j<N;j++) {
				int cur = road[i][j];
				if(Math.abs(prev-cur)>1) {
					check = false;
					break;
				} else if(prev == cur) { //같다면
					cnt++;
					if(left) { // 이전값 탐색 중이였다면 
						if(cnt>=L) { // 길이가 L이 될경우
							cnt = cnt - L; // L만큼 빼준다..ㅠ
							left = false;// 탐색을 종료합니다~
						}
					}
				} else { // 차가 1일때 
					if(prev>cur) { // 이전값이 현재 값보다 크다면
						if(left) {
							if(cnt!=L) {
								check = false;
								break;
							}
						} else {							
							cnt = 1;
							left=true;
						}
					} else {
						if(cnt < L) {
							check = false;
							break;
						}
						if(L==1) {
							if(left) {
								check = false;
								break;
							}
						}
					}
				}
				prev = cur;
				// 잘가다가 큰놈을 만나면 
			}
			if(left) {
				if(cnt<L) // 범위 벗어나면
					check = false;
			}
			if(check) {
			//	System.out.println(i);
				ans++;
			}
		}
	}
	
	static void vertical() {
		for(int i =0;i<N;i++) {
			boolean check = true;
			//시작할때 처음 값을 미리 저장한다. 
			// 이전 값이 1보다 크면 return;
			int prev = road[0][i];
			int cnt = 1;
			boolean left = false;
			for(int j =1;j<N;j++) {
				int cur = road[j][i];
//				if(i==0) {
//					System.out.print(j + " " + left);
//				}
				if(Math.abs(prev-cur)>1) {
					check = false;
					break;
				} else if(prev == cur) { //같다면
					cnt++;
					if(left) { // 이전값 탐색 중이였다면 
						if(cnt>=L) { // 길이가 L이 될경우
							cnt = cnt - L; // L만큼 빼준다..ㅠ
							left = false;// 탐색을 종료합니다~
						}
					}
				} else { // 차가 1일때 
					if(prev>cur) { // 이전값이 현재 값보다 크다면
						if(left) {
							if(cnt!=L) {
								check = false;
								break;
							}
						} else {							
							cnt = 1;
							left=true;
						}
					} else {
						if(cnt < L) {
							check = false;
							break;
						}
						cnt = 1;
						if(L==1) {
							if(left) {
								check = false;
								break;
							}
						}
					}
				}
				prev = cur;
				// 잘가다가 큰놈을 만나면 
			}
			if(left) {
				if(cnt<L) // 범위 벗어나면
					check = false;
			}
			if(check) {
			//	System.out.println(i);
				ans++;
			}
		}
	}
		
	public static void main(String[] args) {
		input();
		//System.out.println("가로");
		horrison();
		//System.out.println("세로");
		vertical();
		System.out.println(ans);
	}

}

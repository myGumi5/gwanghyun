import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Archer {
	int pos;
	int[] attack;
	int cnt;
	public Archer(int pos, int[] attack, int cnt) {
		super();
		this.pos = pos;
		this.attack = attack;
		this.cnt = cnt;
	}
	
}
public class BOJ17135 {
	
	static int N,M,D;
	static int[][] main_map;
	static int[][] cur_map;
	static int[] mil = new int[3];
	static Archer[] archer = new Archer[3];
	static boolean[] v;
	static int CNT = 0;
	static int ans = 0;
	public static void main(String[] args) {
		
		input();
		start(0,0);
		System.out.println(ans);
	}
	public static void reset() {
		for (int i =0;i<N;i++) {
			for (int j =0;j<M;j++) {
				cur_map[i][j] = main_map[i][j];
			}
		}
	}
	static void wave() {
		int sum = 0;
//		for(int i = 0; i<3;i++) {
//			System.out.print(archer[i].pos + " ");
//		}
//		System.out.println("시작");
		for (int w = 0; w<N;w++) {
			int[][] tmp_map = new int[N][M];
			if(w != 0) { // 한칸씩 이동 
				int cnt = 0;
				for(int i = N-1;i>0;i--) {
					for(int j = 0; j<M;j++) {
						tmp_map[i][j] = cur_map[i-1][j];
						if(tmp_map[i][j] == 1) {
							cnt++;
						}
					}
				}
				if(cnt == 0) {
					break;
				}
			} else {
				for(int i = 0;i<N;i++) {
					for(int j = 0; j<M;j++) {
						tmp_map[i][j] = cur_map[i][j];
					}
				}
			}
//				System.out.println();
//				for(int i = 0; i<N;i++) {
//					for(int j = 0; j<N;j++) {
//						System.out.print(tmp_map[i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			for(int i =0; i<3;i++) {
				archer[i].attack = new int[2];
				archer[i].cnt = -1;
			}
			for(int i = 0;i<N;i++) {
				for(int j = 0; j<M;j++) {
					cur_map[i][j] = tmp_map[i][j];
				}
			}
			sum += attack();
		}
		ans = Math.max(ans, sum);
	}
	static int attack() {
		Queue<int[]> q = new LinkedList<>();
		int at = 0;
		
		for(int i = N-1;i>=0;i--) {
			for(int j =0; j<M;j++) {
				if(cur_map[i][j] == 1) {
					int[] d = new int[3];
					for(int w =0;w<3;w++) {
						d[w] = Math.abs(N-i) + Math.abs(archer[w].pos - j);
						if(d[w]<=D) {
							if(archer[w].cnt == -1 || archer[w].cnt>d[w]) {
								archer[w].cnt = d[w];
								archer[w].attack[0] = i;
								archer[w].attack[1] = j;
//								System.out.println("i : "+ i + "  j : "+j);
//								System.out.println(w + "  " +d[w]);
							}
						}
					}
				}
			}
		}
		for(Archer a : archer) {
			if(a.cnt!=-1) {
				if(cur_map[a.attack[0]][a.attack[1]] == 0)
					continue;
				at++;
				cur_map[a.attack[0]][a.attack[1]] = 0;
			}
		}
		return at;
	}
	
	static void start(int idx,int n) {
		if(n==3) {
			reset();
			wave();
			return;
		}
		for(int i = idx; i<M;i++) {
			if(!v[i]) {
				v[i] = true;
				archer[n] = new Archer(i,new int[2],0); 
				start(idx+1,n+1);
				v[i] = false;
			}
		}
	}
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		main_map = new int[N][M];
		cur_map = new int[N][M];
		v = new boolean[M];
		for (int i =0;i<N;i++) {
			for (int j =0;j<M;j++) {
				main_map[i][j] = sc.nextInt();
				if(main_map[i][j] == 1)
					CNT++;
			}
		}
	}
}

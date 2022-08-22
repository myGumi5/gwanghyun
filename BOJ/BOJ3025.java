import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
class XY{
	int x,y;

	public XY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class BOJ3025 {

	
	static int N,M,K;
	static char[][] map;
	static Stack<XY>[] S;
	
	static void start(int x,int y, int tc) {
		while(true) {
			if(x == N-1) {
				break;
			}
			if(map[x+1][y] == 'X') {
				break;
			}
			if(map[x+1][y] == 'O') {
				if(y-1>=0 && map[x][y-1] == '.' && map[x+1][y-1]=='.') {
					x++;
					y--;
				} else if(y+1<M && map[x][y+1] == '.' && map[x+1][y+1] == '.') {
					x++;
					y++;
				} else {
					break;
				}
			} else {
				x++;
			}
			S[tc].push(new XY(x,y));
		}
		map[x][y] = 'O';
	}
	
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		S = new Stack[M];
		for(int j = 0;j<M;j++) {
			S[j] = new Stack<>();
		}
		for(int i =0;i<N;i++) {
			map[i] = sc.next().toCharArray();
		}
		
		K = sc.nextInt();
		for(int k =0; k<K;k++) {
			int tc = sc.nextInt() -1 ;
			while(!S[tc].isEmpty()) {
				XY tmp = S[tc].peek();
				if(map[tmp.x][tmp.y] == 'O' ) {
					S[tc].pop();
				} else {
					break;
				}
			}
			if(S[tc].isEmpty()) {
				start(0,tc,tc);
			} else {
				XY t = S[tc].peek();
				start(t.x,t.y,tc);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<M;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static class FastIn {
		BufferedReader br;
		StringTokenizer st;
		FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st==null||!st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}

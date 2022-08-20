import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;
class Tree {
  int x,y,z;
  Tree(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
}
public class Main {
  static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static Queue<Integer> q = new LinkedList<>();
	static int N,M,K;
	static int[][] A;
  static List<Integer>[][] pos;
  static int[][] map;
  static Deque<Tree> trees;
	public static void main(String[] args) {
		FastIn sc = new FastIn();
		N = sc.nextInt();
    M = sc.nextInt();
    K = sc.nextInt();
    
    A = new int[N][N];
    map = new int[N][N];    
    trees = new LinkedList<>();
		for(int i = 0 ; i < N ; i++) {
      for(int j =0;j<N;j++) {
        A[i][j] = sc.nextInt();
        map[i][j] = 5; //처음에는 양분이 5씩 들어있다.
      }
    }
    for(int i = 0; i < M; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int z = sc.nextInt();
      trees.add(new Tree(x-1,y-1,z));
      
    }
    for(int t = 0 ; t<K;t++) {
      List<Tree> die = new ArrayList<>();
      int size = trees.size();
      for(int i = 0; i < size;i++) {
        Tree tmp = trees.poll();
        int x = tmp.x, y = tmp.y;
        if(map[x][y] - tmp.z >=0) {
          trees.add(new Tree(x,y,tmp.z +1));
          map[x][y] -= tmp.z;
        } else {
          die.add(tmp);
        }
      }
      for(int i = 0; i<die.size();i++) {
        int x = die.get(i).x;
        int y = die.get(i).y;
        map[x][y] +=  die.get(i).z/2;
      }
      List<Tree> baby = new LinkedList<>();
      int tsize = trees.size();
      for(Tree now : trees) {
        if(now.z % 5 == 0) {
          for(int j = 0; j <8 ; j++) {
            int nx = now.x + dx[j];
            int ny = now.y + dy[j];
            if(nx<0||nx>=N||ny<0||ny>=N) {
              continue;
            }
            baby.add(new Tree(nx,ny,1));
          }
        }
      }
      for(Tree b : baby)
        trees.offerFirst(b);
      for(int i = 0; i <N;i++) {
        for(int j = 0; j < N;j++) {
          map[i][j] +=A[i][j];
        }
      }
      
    }
    
    System.out.println(trees.size());
	}
	
	static class FastIn {
		BufferedReader br;
		StringTokenizer st;
		
		public FastIn() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			
			while(st ==null||!st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}

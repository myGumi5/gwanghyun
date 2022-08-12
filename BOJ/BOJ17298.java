import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
4
3 5 2 7
 * 
 * */
public class BOJ17298 {

	static int[] box;
	public static void main(String[] args) {
		FastIo sc = new FastIo();
		int n = sc.nextInt();
		int[] OKN = new int[n];
		Stack<Integer> s = new Stack<>();
		box = new int[n];
		for(int i = 0;i<n;i++) {
			box[i] = sc.nextInt();
			OKN[i] = -1;
		}
//		int pre = box[n-1];
//		for(int i = n-2; i>=1;i--) {
//			if(box[i]<pre) {
//				OKN[i] = pre;
//				if(box[i]>box[i-1])
//					pre = box[i];
//			}
//			else  {
//				pre = box[i];
//				
//			}
//		}
//		if(box[0]<pre)
//			OKN[0] = pre;
		// N*N 이라 시간 초과
		int i = 0;
		while (i<n) {
			if(OKN[i] != -1) {
				i++;
				continue;
			}
			for(int j = i+1; j<n;j++) {
				if(box[i]>=box[j]) {
					if(OKN[j] != -1)
						s.push(j);
				}
				else {
					OKN[i] = box[j];
					break;
				}
			}
			int size = s.size();
			for(int j = 0; j<size;j++) {
				int index = s.pop();
				OKN[index] = OKN[i];
			}
			if(size == 0) {
				i++;
				continue;
			}
			i += size;
		}
		StringBuilder sb = new StringBuilder();
		for(int j =0; j<n; j++) {
			sb.append(OKN[j]).append(' ');
		}
		System.out.println(sb);
	}
	
	static class FastIo {
		BufferedReader br;
		StringTokenizer st;
		
		FastIo() {
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

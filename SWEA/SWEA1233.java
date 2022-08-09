import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	String x;
	int r,l;
	public Node(String x, int r, int l) {
		super();
		this.x = x;
		this.r = r;
		this.l = l;
	}
	public Node() {
		super();
	}
	
}


/*if(tree.get(index).x.charAt(0)=='-' || tree.get(index).x.charAt(0)=='+' 
		|| tree.get(index).x.charAt(0)=='*' || tree.get(index).x.charAt(0)=='/')
	if(isNum) {
		isNum =false;
	} else {
		ans= false;
		return;
	}
else 
	if(isNum) {
		ans= false;
		return;
	}				
	else 
		isNum = true;*/
public class SWEA1233 {
	static List<Node> tree;
	static boolean isNum = false;
	static boolean ans = true;
	
	static int postorder(int index) {
		if(index == 0 || !ans )
			return -1;
		int x =-1, y = -1;
		
		
		if(tree.get(index).l !=0) {
			x = postorder(tree.get(index).l);
		}
		if(tree.get(index).r !=0) {
			y = postorder(tree.get(index).r);
		}
		
		switch(tree.get(index).x.charAt(0)) {
		case '-':
		case '*':
		case '+':
		case '/':
			tree.get(index).x = String.valueOf(1);
			break;
		default:
			if(x==-1 && y != -1 || x!=-1 && y == -1 || x!= -1 && y != -1)
				ans = false;
			break;
	
		}
		return Integer.parseInt(tree.get(index).x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			ans = true;
			tree = new ArrayList<>();
			tree.add(new Node("0",0,0));
			boolean check = false;
			for(int i = 1 ; i<=N;i++) {
				Node tmp = new Node();
				int point = sc.nextInt();
				tmp.x = sc.next();
				if(!check) {
					tmp.l = sc.nextInt();
					if(tmp.l != N) {
						tmp.r = sc.nextInt();
						if(tmp.r == N)
							check = true;
					} else {
						check = true;
					}
				} else {
					tmp.l = 0;
					tmp.r = 0;
				}
				tree.add(tmp);
			} // 입력 끝
			postorder(1);
			if(ans)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

}

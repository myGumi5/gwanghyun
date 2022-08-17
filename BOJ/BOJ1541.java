import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1541 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		ArrayList<String> strs = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		//입력 
		for(int i = 0 ; i <s.length();i++) {
			char key = s.charAt(i);
			if(key != '+' && key != '-') {
				sb.append(key);
			}else if(key =='+' || key == '-') {
				strs.add(sb.toString());
				sb = new StringBuilder();
				strs.add(String.valueOf(key));
			} 
		}
		strs.add(sb.toString());
		
		
		int sum = Integer.parseInt(strs.get(0)); // 맨 처음 값 저장 
		int idx= 1; // 맨 처음값을 저장했으니 빼고 시작
		while(idx <strs.size()-1) { // b값도 빼야하므로 size-1 까지 
			char c = strs.get(idx).charAt(0);
			int b = Integer.parseInt(strs.get(++idx));
			if(c=='+') {
				sum += b;
				idx++;
			} else { // - 일때 
				if(idx+2 < strs.size()) { // 다음 연산자가 존재 한다면 
					int tmp = b; // tmp에 b값 저장 
					int i = 0;
					for(i = idx+1; i < strs.size();i=i+2) { // 다음 연산자 확인  
						if(strs.get(i).charAt(0) == '-') { // 다음 연산자가 -일시 break 하고 idx를 i로 변경
							idx = i;
							break;
						} else { // 다음 연산자가 +일시
							tmp += Integer.parseInt(strs.get(i+1)); // 이전값들의 합을 모두 더해서 저장
							idx = i+2; // idx도 같이 증가
						}
					}
					sum -= tmp; // 이전값들의 합을 값에서 빼기
				} else {
					sum -= b; // 다음 연산자가 없으니 바로 뺀다 
				}
			}
		}
		System.out.println(sum);
		
		//55-50+40
	}

}

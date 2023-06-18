import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int push = 1; //오름차순 정수
		boolean check = true;
		
		for(int j = 0; j<n; j++) {
			int step = Integer.parseInt(br.readLine());
				while(true) {
					if(push<=step) {
						stack.push(push++); str.append(("+\n"));
					}else if(stack.peek() == step) {
						stack.pop();str.append(("-\n")); break;
					}else {
						check = false; break;
					}
				}
		}
		if(check) System.out.print(str);
		else System.out.println("NO");
	}
}
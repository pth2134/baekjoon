import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		try {
			int t =Integer.parseInt(br.readLine());
			Stack<Integer> stack = new Stack<>();
			int sum = 0;
			while(t-->0) {
				st = new StringTokenizer(br.readLine());
				int input = Integer.parseInt(st.nextToken());
				if(input !=0) {
					stack.push(input);
					sum +=input;
				}
				else {
					sum -=stack.peek();
					stack.pop();
				}
			}
			bw.write(sum+"");
			bw.flush();
			
		
		
		
		} catch (IOException e) {
			
		}
	}
}

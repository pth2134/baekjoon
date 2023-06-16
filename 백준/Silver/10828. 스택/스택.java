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
			while(t-->0) {
				st = new StringTokenizer(br.readLine());
				String input = st.nextToken();
				switch (input) {
				case "push":
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if(stack.empty()) {
						bw.write(-1+"\n");
					}
					else{ 
						bw.write(stack.pop()+"\n");
					}
					break;
				case "size":
					bw.write(stack.size()+"\n");
					break;
				case "empty":
					if(stack.empty()) {
						bw.write(1+"\n");
					}
					else{ 
						bw.write(0+"\n");
					}
					break;
				case "top":
					if(stack.empty()) {
						bw.write(-1+"\n");
					}
					else{ 
						bw.write(stack.peek()+"\n");
					}
					break;

				default:
					break;
				}
			}
			
			bw.flush();
			
		
		
		
		} catch (IOException e) {
			
		}
	}
}

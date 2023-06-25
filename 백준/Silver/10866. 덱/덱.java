import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Deque<Integer> dq = new ArrayDeque<>();
		int t = Integer.parseInt(br.readLine());
		for(int i =0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			switch (input) {
			case "push_front":
				dq.addFirst(Integer.parseInt(st.nextToken()));				
				break;
				
			case "push_back" :
				dq.addLast(Integer.parseInt(st.nextToken()));				
				break;
			case "pop_front" :
				if(!dq.isEmpty()) {
				bw.write(dq.pollFirst()+"\n");
				} else {
					bw.write(-1+"\n"); 
					}
				break;
			case "pop_back" :
				if(!dq.isEmpty()) {
				bw.write(dq.pollLast()+"\n");
				} else {
					bw.write(-1+"\n"); 
					}
				break;
			case "size" :
				bw.write(dq.size()+"\n");
				break;
			case "empty":
				if(dq.isEmpty()) {
					bw.write(1+"\n");
				} else {
					bw.write(0+"\n");
				}
				break;
			case "front" :
				if(!dq.isEmpty()) {
					bw.write(dq.peekFirst()+"\n");
					} else {
						bw.write(-1+"\n"); 
						}
					break;
			case "back" :
				if(!dq.isEmpty()) {
					bw.write(dq.peekLast()+"\n");
					} else {
						bw.write(-1+"\n"); 
						}
					break;

			default:
				break;
			}
		}
		bw.flush();
	}
}

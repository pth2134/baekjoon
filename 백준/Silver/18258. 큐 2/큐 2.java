import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<>();
		int last = 0;
		
		for (int i = 0; i <n; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
				switch (input) {
				case "push":
					last = Integer.parseInt(st.nextToken());
					que.add(last);
					break;
				case "pop":
					if(que.isEmpty()) {
						bw.write(-1+"\n");
					} else bw.write(que.poll()+"\n");
					break;
				case "size":
					bw.write(que.size()+"\n");
					break;
				case "empty":
					if(que.isEmpty()) {
						bw.write(1+"\n");
					} else bw.write(0+"\n");
					break;
				case "front":
					if(que.isEmpty()) {
						bw.write(-1+"\n");
					} else bw.write(que.peek()+"\n");
					break;
				case "back":
					if(que.isEmpty()) {
						bw.write(-1+"\n");
					} else bw.write(last+"\n");
					break;
				default:
					break;
				}
			
		}
		
		bw.flush();
		
	}
}

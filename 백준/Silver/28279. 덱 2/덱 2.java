import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();		
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int input = Integer.parseInt(st.nextToken());  
				switch (input) {
				case 1:
					dq.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case 2:
					dq.addLast(Integer.parseInt(st.nextToken()));
					break;
				case 3:
					if(!dq.isEmpty()) {
						bw.write(dq.pollFirst()+"\n");
					} else {
						bw.write(-1+"\n");
					}
					break;
				case 4:
					if(!dq.isEmpty()) {
						bw.write(dq.pollLast()+"\n");
					} else {
						bw.write(-1+"\n");
					}
					break;
				case 5:
					bw.write(dq.size()+"\n");
					break;
				case 6:
					if(dq.isEmpty()) {
						bw.write(1+"\n");
					} else {
						bw.write(0+"\n");
					}
					break;
				case 7:
					if(!dq.isEmpty()) {
						bw.write(dq.peekFirst()+"\n");
					} else {
						bw.write(-1+"\n");
					}
					break;
				case 8:
					if(!dq.isEmpty()) {
						bw.write(dq.peekLast()+"\n");
					} else {
						bw.write(-1+"\n");
					}
					break;
				}
			}
			
			
			bw.flush();
		}
 }
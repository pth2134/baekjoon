import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();
			Stack<Integer> s2 = new Stack<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				dq.addLast(Integer.parseInt(st.nextToken()));
			}
			
			int i = 1;
			boolean result = true;
			while(i<=n) {
				if(!dq.isEmpty()) {
					if(dq.peekFirst()==i) {
						dq.pop();
						i++;
						continue;
					}
				}
				if(!s2.empty()) {
					if(s2.peek()==i) {
						s2.pop();
						i++;
						continue;
					}
				}
				if(dq.isEmpty()) {
					result = false;
					break;
				} else {
					s2.push(dq.pop());
				}
			}
			if(result) {
				bw.write("Nice");
			} else {
				bw.write("Sad");
			}
			bw.flush();
		}
 }
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		for (int i = 0; i < t; i++) {
			char[] c = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(),"[],");
			for (int j = 0; j < n; j++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean reverse = false;
			boolean error = false;
			for (int j = 0; j < c.length; j++) {
				if(c[j] == 'R') {
					reverse = !reverse;
				} else {
					if(dq.isEmpty()) {
						bw.write("error\n");
						error =true;
						break;
					}
					if(reverse) {
						dq.pollLast();
					} else {
						dq.pollFirst();
					}
				}
			}
			
			if(error) continue;
			if(reverse) {
				bw.write("[");
				if(!dq.isEmpty()) {
					bw.write(dq.pollLast()+"");
				}
				while(!dq.isEmpty()) {
					bw.write(","+dq.pollLast());
				}
				bw.write("]\n");
			} else {
				bw.write("[");
				if(!dq.isEmpty()) {
					bw.write(dq.pollFirst()+"");
				}
				while(!dq.isEmpty()) {
					bw.write(","+dq.pollFirst());
				}
				bw.write("]\n");
			}
			
		}
	
		bw.flush();
	}
	
}
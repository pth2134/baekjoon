import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			
			boolean[] A = new boolean[n];
			int[] B = new int[n];
			st = new StringTokenizer(br.readLine());
			int i2 = 0;
			for(int i =0; i<n; i++) {
				A[i] = Integer.parseInt(st.nextToken())==0? true : false;
				if(A[i]) i2++;
			}
			
			Deque<String> dq = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for(int i =0; i<n; i++) {
				if(A[i]) dq.add(st.nextToken());
				else st.nextToken();
			}
			
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			if(!dq.isEmpty()) {
				for(int i=0; i<m; i++) {
					bw.write(dq.pollLast()+" ");
					dq.addFirst(st.nextToken());
				}
			} else {
				for(int i=0; i<m; i++) {
					bw.write(st.nextToken()+" ");
				}
			}
			
			bw.flush();
		}
 }
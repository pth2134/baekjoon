import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();
			int[] arr = new int[n+1];
			for(int i =2; i<=n; i++) {
				dq.addLast(i);
			}
			
			for(int i =1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int poll = arr[1];
			bw.write(1+" ");
			for(int i=1; i<n; i++) {
				if(poll>0) {
					for(int j=1; j<poll; j++) {
						dq.addLast(dq.pollFirst());
					}
					poll = dq.pollFirst();
				} else {
					for(int j=1; j<-poll; j++) {
						dq.addFirst(dq.pollLast());
					}
					poll = dq.pollLast();
				}
				bw.write(poll+" ");
				poll = arr[poll];
			}
			
			bw.flush();
		}
 }
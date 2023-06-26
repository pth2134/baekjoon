import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i =1; i<=n; i++) {
			q.add(i);
		}
		
		int shift = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<m; i++) {
			int left = 0;
			int target = Integer.parseInt(st.nextToken());
			while(q.peek()!=target) {
				q.add(q.poll());
				left ++;
			}
			if(left>q.size()/2) {
				left = q.size() - left;
			}
			q.poll();
			shift += left;
		}
		
		bw.write(shift+"");
		bw.flush();
	}
}
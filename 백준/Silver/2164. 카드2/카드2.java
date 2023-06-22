import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i =1; i<=n; i++) {
			q.add(i);
		}
		int last =0;
		while(!q.isEmpty()) {
			last = q.poll();
			try {
				q.add(q.peek());
				last = q.poll();
			} catch (NullPointerException e) {
				break;
			}
			
		}
		bw.write(last+"");
		bw.flush();
	}
}
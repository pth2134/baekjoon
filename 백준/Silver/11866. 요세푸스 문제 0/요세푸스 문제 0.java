import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] yo = new int[n];
		
		Queue<Integer> q = new LinkedList<>();
		for(int i =1; i<=n; i++) {
			q.add(i);
		}
		
		int o =0;
		while(!q.isEmpty()) {
			for(int i =0; i<k-1; i++) {
				q.add(q.poll());
			}
			yo[o++]=q.poll();
		}
		
		bw.write("<");
		for(int i=0; i<n-1; i++) {
			bw.write(yo[i]+", ");
		}
		bw.write(yo[n-1]+">");
		bw.flush();
	}
}
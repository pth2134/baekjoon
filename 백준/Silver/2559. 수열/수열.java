import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i =0; i<k; i++) {
			int input = Integer.parseInt(st.nextToken());
			dq.addLast(input);
			sum += input;
		}
		
		int max = sum;
		
		for(int i =k; i<n; i++) {
			int input = Integer.parseInt(st.nextToken());
			dq.addLast(input);
			sum += input;
			sum -= dq.pollFirst();
			max = max<sum? sum : max;
		}
		
		bw.write(max+"");
		bw.flush();
	}
}

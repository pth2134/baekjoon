import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> mh = new PriorityQueue<>();
		long[] a = new long[n];
		long max = 0;
		for(int i =0; i<n; i++) {
			a[i] = Long.parseLong(st.nextToken());
			max = Math.max(a[i],max);
		}
		for(int i =0; i<n; i++) {
			while(a[i]<=max) {
				a[i]*=2;
			}
			if(a[i]>max) a[i]/=2;
			mh.add(a[i]);
		}
		long min = max;

		for (int i = 0; i < n; i++) {
			long poll = mh.poll();
			min = Math.min(min,max-poll);
			max = poll*2;
		}

		System.out.println(min);
	}
}
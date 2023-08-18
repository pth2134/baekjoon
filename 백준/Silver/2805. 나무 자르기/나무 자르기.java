import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long m = Integer.parseInt(st.nextToken());
			long[] tree = new long[n];
			long max = 0;
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				tree[i] = Long.parseLong(st.nextToken());
				if(max < tree[i]) max = tree[i];
			}
			
			long low = 0;
			long hi = max;
			
			while(low < hi) {
				long mid = (low+hi)/2;
				long get = 0;
				for(int i=0; i<n; i++) {
					if(tree[i] > mid) {
						get+=tree[i] - mid;
					}
				}
				
				if(get >= m) {
					low = mid+1;
				} else {
					hi = mid;
				}
			}
			
			System.out.println(low-1);
		}
 }
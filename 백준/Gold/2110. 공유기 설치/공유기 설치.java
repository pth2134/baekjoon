import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			long[] home = new long[n];
			long[] dis = new long[n];

			
			for(int i = 0; i<n; i++) {
				home[i] = Long.parseLong(br.readLine());
			}
			
			Arrays.sort(home);
			
			for(int i = 1; i<n; i++) {
				dis[i] = home[i]-home[i-1];
			}
			
			long low = 0;
			long hi = home[n-1]+1;
			c--;
			while(low < hi) {
				long mid = (low + hi)/2;
				int set = c;
				int std = 0;
				for(int i =1; i<n; i++) {
					std+= dis[i];
					if(std >= mid) {
						set--;
						std = 0;
					}
				}
				
				if(set <= 0) {
					low = mid +1;
				} else {
					hi = mid;
				}
			}
			
			System.out.println(low-1);
	}
 }
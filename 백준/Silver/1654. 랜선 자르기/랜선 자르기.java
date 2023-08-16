import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[] yong = new int[k];
			long max = 0;
			for(int i =0; i<k; i++) {
				yong[i] = Integer.parseInt(br.readLine());
				if(yong[i] > max) max = yong[i];
			}
			
			long low = max/n;			
			long hi = max+1;
			
			while(low<hi) {
				long mid = (low+hi)/2;
				long count = 0;
				for(int i =0; i<k; i++) {
					count+= yong[i]/mid;
				}
				if(count>=n) {
					low = mid+1;
				} else {
					hi = mid;
				}
				
			}
			
			System.out.println(low-1);
		}
 }
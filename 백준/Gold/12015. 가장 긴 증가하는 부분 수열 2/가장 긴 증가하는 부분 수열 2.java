import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			int n = Integer.parseInt(br.readLine());
			int[] pr = new int[n+1];
			int[] lis = new int[n+1];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= n; i++) {
				pr[i] = Integer.parseInt(st.nextToken());
			}
			
			int lisEnd = 0;
			
			for(int i =1; i<=n; i++) {
				if(pr[i]>lis[lisEnd]) {
					lis[++lisEnd] = pr[i]; 
				} else {
					int low = 0;
					int hi = lisEnd+1;
					while(low < hi) {
						int mid = (low +hi)/2;
						if(lis[mid] >= pr[i]) {
							hi = mid;
						} else {
							low = mid+1;
						}
					}
					lis[low] = pr[i];
				}
			}
			
			System.out.println(lisEnd);
			
			
	}
 }
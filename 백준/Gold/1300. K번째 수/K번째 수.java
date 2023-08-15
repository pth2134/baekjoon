import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			int k = Integer.parseInt(br.readLine());
			
			int hi = k;
			int low = 1;
			
			while(low < hi) {
				int mid = (low+hi)/2;
				long count = 0;
				
				int min = mid<n? mid : n;
				for(int i = 1; i<=min; i++) {
					count += Math.min(mid/i,n);
				}
				
				if(k <= count) {
					hi = mid;
				} else {
					low = mid +1;
				}
				
			}
			
			System.out.println(low);
		}
 }
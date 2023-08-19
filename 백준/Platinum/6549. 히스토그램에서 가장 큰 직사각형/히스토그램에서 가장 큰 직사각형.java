import java.io.*;
import java.util.*;

class Main{
	static long[] h;
	
	static long div(int low, int hi) {
		if(low == hi) return h[low]; 
		int mid = (low+hi)/2;
		
		long left = div(low,mid);
		long right = div(mid+1,hi);
		long max = left>right? left : right;
		
		long height = h[mid];
		int leftm = mid, rightm = mid;
		long middleMax = height;
		
		while(leftm > low && rightm < hi) {
			if(h[leftm -1] < h[rightm +1]) {
				rightm++;
				height = height > h[rightm]? h[rightm] : height;
			} else {
				leftm--;
				height = height > h[leftm]? h[leftm] : height;
			}
			middleMax = Math.max(middleMax, height*(rightm - leftm+1));
		}
		
		while(leftm > low) {
			leftm--;
			height = height > h[leftm]? h[leftm] : height;
			middleMax = Math.max(middleMax, height*(rightm - leftm+1));
		}
		
		while(rightm < hi) {
			rightm++;
			height = height > h[rightm]? h[rightm] : height;
			middleMax = Math.max(middleMax, height*(rightm - leftm+1));
		}
		
		max = max > middleMax ? max : middleMax;
		
		return max;
	}

	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder str = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			while(n!=0) {
				h = new long[n];
				for(int i =0; i<n; i++) {
					h[i] = Long.parseLong(st.nextToken());
				}
				str.append(div(0,n-1)+"\n");
				st = new StringTokenizer(br.readLine());
				n = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(str);
		}
 }
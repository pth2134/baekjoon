import java.io.*;
import java.util.*;
class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] height = new int[n];
		int max = 0;
		height[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			max = Math.max(height[i]-height[i-1],max);
		}
		int[] gap = new int[max+1];
		for (int i = 1; i < n; i++) {
			gap[height[i]-height[i-1]]++;
		}
		int sum = 0;
		for (int i = 0; i < gap.length; i++) {
			if(gap[i]>0){
				n-=gap[i];
				if(n<=k){
					sum+=(gap[i]-k+n)*i;
					break;
				}
				sum+=gap[i]*i;
			}
		}
		System.out.println(sum);
	}
}
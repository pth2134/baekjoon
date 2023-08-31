import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] cost = new int[n+1];
		int[] memory = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum+= cost[i];
		}

		int min = sum; //c의 최소값
		int[][] dp = new int[n+1][sum+1];
		for(int i = 1; i<=n; i++){
			for(int j = 0; j<cost[i]; j++) {
				dp[i][j] = dp[i-1][j];
			}
			for(int j = cost[i]; j<min; j++) {
				dp[i][j] = Math.max(dp[i-1][j],memory[i]+dp[i-1][j-cost[i]]);
				if(dp[i][j] >= m){
					min = j;
				}
			}
		}

		System.out.println(min);
	}
 }
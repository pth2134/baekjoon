import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] weight = new int[n+1];
		int[] sum = new int[n+1];
		for (int i = 1; i <= n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
			sum[i] += sum[i-1] + weight[i];
		}
		boolean[][] dp = new boolean[n+1][sum[n]+1];
		dp[0][0] = true;
		for(int i = 1; i<=n; i++){
			int w = weight[i];
			for (int j = 0; j <= sum[i]-w; j++) {
				if(dp[i-1][j]){
					dp[i][j+w] = true;
					dp[i][j] = true;
					dp[i][Math.abs(j-w)] = true;
				}
			}
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= m; i++) {
			int w = Integer.parseInt(st.nextToken());
			if(w > sum[n]){
				str.append("N ");
			} else if(dp[n][w]){
				str.append("Y ");
			} else{
				str.append("N ");
			}
		}
		System.out.println(str);

	}
 }
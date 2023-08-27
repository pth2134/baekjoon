import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] mp = new int[n+1][2];
		int[][][] dp = new int[n+1][n+1][3];


		for (int j = 1; j <= n; j++) {
			st= new StringTokenizer(br.readLine());
			dp[j][j][1] = Integer.parseInt(st.nextToken());
			dp[j][j][2] = Integer.parseInt(st.nextToken());
		}

		for (int j = 1; j < n; j++) {
			for (int l = 1; j+l <= n ; l++) {
				int f = j+l;
				dp[l][f][0] = Integer.MAX_VALUE;
				for (int m = l; m < f; m++) {
					if(dp[l][f][0] > dp[l][m][0] + dp[m+1][f][0] + dp[l][m][1]*dp[l][m][2]*dp[m+1][f][2]){
						dp[l][f][0] = dp[l][m][0] + dp[m+1][f][0] + dp[l][m][1]*dp[l][m][2]*dp[m+1][f][2];
						dp[l][f][1] = dp[l][m][1];
						dp[l][f][2] = dp[m+1][f][2];
					}
				}
			}
		}

		System.out.println(dp[1][n][0]);
	}
 }
import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {

			int k = Integer.parseInt(br.readLine());
			int[] ch = new int[k+1];
			int[] sum = new int[k+1];
			int[][] dp = new int[k+1][k+1];

			st= new StringTokenizer(br.readLine());
			for (int j = 1; j <= k; j++) {
				ch[j] = Integer.parseInt(st.nextToken());
				sum[j] = sum[j-1]+ch[j];
			}

			for (int j = 1; j < k; j++) {
				for (int l = 1; j+l <= k ; l++) {
					int f = j+l;
					dp[l][f] = Integer.MAX_VALUE;
					for (int m = l; m < f; m++) {
						dp[l][f] = Math.min(dp[l][f], dp[l][m] + dp[m+1][f] + sum[f] - sum[l-1]);
					}
				}
			}

			str.append(dp[1][k]).append("\n");
		}
		System.out.println(str);
	}
 }
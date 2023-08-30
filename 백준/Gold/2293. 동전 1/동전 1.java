import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		for(int i =0; i<n; i++){
			coin[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[k+1];
		dp[0] = 1;
		for(int i =0; i<n; i++) {
			int now = coin[i];
			for (int j = now; j <= k; j++) {
				dp[j] = dp[j]+dp[j-now];
			}
		}

		System.out.println(dp[k]);
	}
 }
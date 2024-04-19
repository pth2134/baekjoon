import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		long div = 1000000000;
		long[] dp = new long[Math.max(n + 1, 6)];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 9;
		dp[5] = 44;

		for (int i = 6; i <= n; i++) {
			dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % div;
		}

		System.out.println(dp[n]);
	}

}

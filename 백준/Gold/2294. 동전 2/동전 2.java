import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] dp = new int[k + 1];
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input <= k)
				dp[input] = 1;
		}

		for (int i = 1; i <= k; i++) {
			if (dp[i] != 1) {
				for (int j = 1; j < i; j++) {
					if (dp[j] > 0 && dp[i - j] > 0) {
						int value = dp[j] + dp[i - j];
						if (dp[i] > 1) {
							dp[i] = Integer.min(dp[i], value);
						} else {
							dp[i] = value;
						}
					}
				}
			}
		}

		System.out.println(dp[k] > 0 ? dp[k] : -1);
	}

}


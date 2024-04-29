import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final long MOD = 1_000_000_000L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[][][] dp = new long[n + 1][10][1 << 10]; //[자리수][끝자리숫자][(boolean대체)비트]

		for (int i = 1; i < 10; i++) {
			int bit = 1 << i; //1은 00 0000 0010, 2는 00 0000 0100 이런식으로 boolean대신 사용
			dp[1][i][bit] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 1024; k++) {
					int bit = k | 1 << j; // 기존 k (visit)에 j에 해당하는 비트를 on으로 바꿈
					if (j == 0)
						dp[i][j][bit] += dp[i - 1][1][k]; //끝자리 수가 1이면서 비트마스크가 k인 것의 개수
					else if (j == 9)
						dp[i][j][bit] += dp[i - 1][8][k];
					else
						dp[i][j][bit] += dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k];
					dp[i][j][bit] %= MOD;
				}
			}
		}

		long sum = 0;

		for (int i = 0; i < 10; i++) {
			sum += dp[n][i][1023];
			sum %= MOD;
		}

		System.out.println(sum);
	}

}
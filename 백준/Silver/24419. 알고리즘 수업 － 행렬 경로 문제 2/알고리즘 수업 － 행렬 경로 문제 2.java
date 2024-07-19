import java.io.IOException;

public class Main {
	static int n;
	static long[][] dp;
	static final int INF = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		n = reader.nextInt();
		dp = new long[n][n];

		for (int i = 0; i < n; i++) {
			dp[n - 1][i] = 1;
			dp[i][n - 1] = 1;
		}
		matrixPathRec(n - 2);
		long cnt1 = 0;

		for (int i = 0; i < n; i++) {
			cnt1 += dp[0][i];
			cnt1 += dp[i][0];
			cnt1 %= INF;
		}

		System.out.println(cnt1 + " " + n * n);
	}

	public static void matrixPathRec(int k) {
		if (k == -1)
			return;

		dp[k][k] = dp[k + 1][k] + dp[k][k + 1];

		for (int i = k - 1; i >= 0; i--) {
			dp[k][i] = (dp[k + 1][i] + dp[k][i + 1]) % INF;
			dp[i][k] = (dp[i + 1][k] + dp[i][k + 1]) % INF;
		}

		matrixPathRec(k - 1);
	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

		int nextInt() throws IOException {
			int n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			boolean neg = c == '-';
			if (neg)
				c = read();
			do
				n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
			return neg ? -n : n;
		}

		boolean isNumber(byte c) {
			return 47 < c && c < 58;
		}

		byte read() throws IOException {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}

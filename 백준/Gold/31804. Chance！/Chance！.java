import java.io.IOException;

public class Main {
	static int[][] dp;
	static int b;

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int a = reader.nextInt();
		b = reader.nextInt();
		dp = new int[b + 1][2];

		dp[a][0] = 1;

		for (int i = a; i <= b; i++) {
			int min0 = dp[i - 1][0];
			int min1 = dp[i - 1][1];

			if (i % 2 == 0) {
				if (dp[i / 2][0] > 0) {
					min0 = Math.min(min0, dp[i / 2][0]);
				}

				if (dp[i / 2][1] > 0) {
					min1 = Math.min(min1, dp[i / 2][1]);
				}
			}

			if (i % 10 == 0 && dp[i / 10][0] > 0) {
				min1 = Math.min(dp[i / 10][0], min1);
			}

			dp[i][0] = min0 + 1;
			dp[i][1] = min1 + 1;
		}

		System.out.println(Math.min(dp[b][0], dp[b][1]) - 1);

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

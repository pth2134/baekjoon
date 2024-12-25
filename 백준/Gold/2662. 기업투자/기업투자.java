import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int m = reader.nextInt();
		int[][] cop = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			reader.nextInt();
			for (int j = 1; j <= m; j++) {
				cop[i][j] = reader.nextInt();
			}
		}

		int[][][] dp = new int[n + 1][m + 1][2];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[j][i][0] = dp[j][i - 1][0];
				dp[j][i][1] = 0;
				for (int k = 0; k <= j; k++) {
					int a = dp[j - k][i - 1][0] + cop[k][i];
					if (dp[j][i][0] < a) {
						dp[j][i][0] = a;
						dp[j][i][1] = k;
					}
				}
			}
		}

		int[] arr = new int[m + 1];
		int now = n;

		for (int i = m; i > 0; i--) {
			int s = dp[now][i][1];
			now -= s;
			arr[i] = s;
		}

		sb.append(dp[n][m][0]).append('\n');
		for (int i = 1; i <= m; i++) {
			sb.append(arr[i]).append(' ');
		}

		System.out.println(sb);
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

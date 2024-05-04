public class Main {
	static int n;
	static int[][] dp;
	static int[][] w;
	static int full;
	static final int INF = 16_000_001;

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		n = reader.nextInt();
		dp = new int[n][1 << n];
		w = new int[n][n];
		full = (1 << n) - 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				w[i][j] = reader.nextInt();
			}
		}

		System.out.println(tsp(0, 1));
	}

	public static int tsp(int k, int bit) {

		if (bit == full) {
			if (w[k][0] == 0)
				return INF;
			else
				return w[k][0];
		}

		if (dp[k][bit] != 0)
			return dp[k][bit];

		dp[k][bit] = INF;

		for (int i = 0; i < n; i++) {
			if (w[k][i] == 0 || (bit & (1 << i)) != 0)
				continue;
			int next = bit | (1 << i);

			dp[k][bit] = Math.min(dp[k][bit], tsp(i, next) + w[k][i]);
		}

		return dp[k][bit];
	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

		int nextInt() throws Exception {
			int n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			boolean neg = c == '-' ? true : false;
			if (neg)
				c = read();
			do
				n = (n << 3) + (n << 1) + (c & 15);
			while (isNumber(c = read()));
			return neg ? -n : n;
		}

		boolean isNumber(byte c) {
			return 47 < c && c < 58;
		}

		byte read() throws Exception {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}
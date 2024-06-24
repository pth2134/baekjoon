import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int m = reader.nextInt();
		int[][] value = new int[m][n];
		int[][] dp = new int[n][m];

		for (int dessert = 0; dessert < m; dessert++) {
			for (int day = 0; day < n; day++) {
				value[dessert][day] = reader.nextInt();
			}
		}

		for (int dessert = 0; dessert < m; dessert++) {
			dp[0][dessert] = value[dessert][0];
		}

		for (int day = 1; day < n; day++) {
			for (int dessert = 0; dessert < m; dessert++) {
				for (int prev = 0; prev < m; prev++) {//전날 먹은 디저트 종류마다 최대의 만족감이 기록되어 있음
					if (dessert == prev)
						dp[day][dessert] = Math.max(dp[day][dessert], dp[day - 1][prev] + value[dessert][day] / 2);
					else
						dp[day][dessert] = Math.max(dp[day][dessert], dp[day - 1][prev] + value[dessert][day]);
				}
			}
		}

		int max = 0;

		for (int i = 0; i < m; i++) {
			max = Math.max(max, dp[n - 1][i]);
		}

		System.out.println(max);
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

		long nextLong() throws IOException {
			long n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			boolean neg = c == '-' ? true : false;
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

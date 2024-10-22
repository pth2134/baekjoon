import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int m = reader.nextInt();
		int c = reader.nextInt();
		long[][] worth = new long[c + 1][c + 1];
		int[] A = new int[n + 1];
		int[] B = new int[m + 1];

		for (int i = 1; i <= c; i++) {
			for (int j = 1; j <= c; j++) {
				worth[i][j] = reader.nextLong();
			}
		}

		for (int i = 1; i <= n; i++) {
			A[i] = reader.nextInt();
		}

		for (int i = 1; i <= m; i++) {
			B[i] = reader.nextInt();
		}

		long[][] dp = new long[n + 1][m + 1]; // n번째 사람이 m 이하의 사람과 악수를 했을 때 만족도의 최대값

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], //악수를 안하는 경우
					Math.max(dp[i][j - 1], dp[i - 1][j - 1] + worth[A[i]][B[j]])); //악수를 하는 경우
			}
		}

		System.out.println(dp[n][m]);
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

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();

		int[] dp = new int[1_000_001];
		int idx = 0;
		int order = 1;
		int input;
		int twoCnt = 0;
		int fiveCnt = 0;

		while ((input = reader.nextInt()) != 0) {
			if (input > idx) {
				while (idx < input) {
					int next = idx + 1;
					while (next % 2 == 0) {
						next /= 2;
						twoCnt++;
					}

					while (next % 5 == 0) {
						next /= 5;
						fiveCnt++;
					}

					int min = Math.min(twoCnt, fiveCnt);
					twoCnt -= min;
					fiveCnt -= min;

					idx++;
					dp[idx] = dp[idx - 1] + min;
				}
			}

			sb.append("Case #").append(order++).append(": ").append(dp[input]).append('\n');
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

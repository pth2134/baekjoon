import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();

		long n = reader.nextLong();
		int m = reader.nextInt();
		long x = reader.nextLong();

		long[] cost = new long[m + 1];
		for (int i = 1; i <= m; i++) {
			cost[i] = reader.nextLong();
		}

		for (int i = 1; i < m; i++) {
			long k = Math.min(n,(x - cost[m] * n) / (cost[i] - cost[m]));
			x -= k * cost[i];
			n -= k;
			sb.append(k).append(' ');
		}

		sb.append(n);

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

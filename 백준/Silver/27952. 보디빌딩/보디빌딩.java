import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		long x = reader.nextLong();
		long w = 0L;

		long[] A = new long[n];

		for (int i = 0; i < n; i++) {
			A[i] = reader.nextLong();
		}

		for (int i = 0; i < n; i++) {
			w += reader.nextLong();
			if (w < A[i]) {
				System.out.println(-1);
				return;
			}
		}

		long min = w - A[n - 1];
		System.out.println(min / x);

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
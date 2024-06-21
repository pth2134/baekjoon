import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int range = Math.abs(n) + 1;
		int[] plus = new int[range];
		int[] minus = new int[range];

		final int DIV = 1_000_000_000;

		if (n < 0) {
			minus[0] = 0;
			minus[1] = 1;
			for (int i = 2; i <= -n; i++) {
				minus[i] = (minus[i - 2] - minus[i - 1]) % DIV;
			}
		} else if (n > 0) {
			plus[0] = 0;
			plus[1] = 1;
			for (int i = 2; i <= n; i++) {
				plus[i] = (plus[i - 2] + plus[i - 1]) % DIV;
			}
		}

		int r;

		if (n < 0) {
			r = minus[-n];
		} else {
			r = plus[n];
		}

		if (r < 0) {
			sb.append(-1).append('\n').append(-r);
		} else if (r > 0) {
			sb.append(1).append('\n').append(r);
		} else {
			sb.append(0).append('\n').append(0);
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

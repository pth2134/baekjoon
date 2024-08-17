import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();

		int cnt = 0;
		int i = 1;

		while (cnt < n) {
			int sqrt = (int)Math.sqrt(++i);
			boolean isPrime = true;
			for (int j = 2; j <= sqrt; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime)
				cnt++;
		}

		System.out.println(i);
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

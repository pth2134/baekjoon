import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();

		int n = reader.nextInt();
		int m = reader.nextInt();

		int[] A = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			A[i] = A[i - 1] + reader.nextInt();
		}

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				int value = A[j] - A[i];
				if (value == m) {
					cnt++;
					break;
				}
				if (value > m)
					break;
			}
		}

		System.out.println(cnt);

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

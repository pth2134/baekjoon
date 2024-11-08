import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int[] seq = new int[n];

		int start = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			seq[i] = reader.nextInt();
			if (seq[i] <= n && seq[i] < min) {
				min = seq[i];
				start = i;
			}
		}

		if (start == -1) {
			System.out.println(1);
			return;
		}

		for (int i = start; i < start + n; i++) {
			int idx = i % n;
			if (seq[idx] <= n) {
				if (seq[idx] != seq[start] + i - start) {
					System.out.println(0);
					return;
				}
			}
		}

		System.out.println(1);

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

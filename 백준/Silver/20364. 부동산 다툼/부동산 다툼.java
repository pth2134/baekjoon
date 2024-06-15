import java.io.IOException;

public class Main {
	static int[] block;
	static int n;

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		n = reader.nextInt();
		int q = reader.nextInt();

		block = new int[n + 1];

		for (int i = 1; i <= q; i++) {
			int input = reader.nextInt();

			if (block[input] != 0) {
				sb.append(findParent(input)).append('\n');
				continue;
			}

			build(input, input);
			sb.append(0).append('\n');
		}

		System.out.println(sb);

	}

	static int findParent(int child) {
		if (block[child] == child)
			return child;
		return findParent(block[child]);
	}

	static void build(int node, int value) {
		if (block[node] != 0) {
			block[node] = value;
			return;
		}

		block[node] = value;

		int left = node * 2;
		int right = left + 1;
		if (left <= n)
			build(left, value);
		if (right <= n)
			build(right, value);
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

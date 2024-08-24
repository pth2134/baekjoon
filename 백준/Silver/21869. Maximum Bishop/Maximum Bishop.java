import java.io.IOException;

public class Main {
	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		n = reader.nextInt();
		int cnt = n + Math.max(n - 2, 0);

		sb.append(cnt).append('\n');
		for (int i = 1; i <= n; i++) {
			sb.append(1).append(' ').append(i).append('\n');
		}

		for (int i = 2; i <= n - 1; i++) {
			sb.append(n).append(' ').append(i).append('\n');
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

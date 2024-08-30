import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();

		StringBuilder width = new StringBuilder();
		StringBuilder height = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n * 5; j++) {
				width.append('@');
			}
			width.append('\n');
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				height.append('@');
			}
			height.append('\n');
		}

		sb.append(width).append(height).append(width).append(height).append(width);

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

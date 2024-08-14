import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int gap = 'a' - 'A';

		for (int i = 0; i < n; i++) {
			char c = reader.nextChar();
			if (c >= 'a')
				c -= gap;

			sb.append(c).append(reader.nextLine()).append('\n');
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

		char nextChar() throws IOException {
			byte c;
			while ((c = read()) <= 32)
				;
			return (char)c;
		}

		String nextLine() throws IOException {
			StringBuilder sb = new StringBuilder();
			byte c;
			if ((c = read()) <= 10)
				return "";
			do {
				sb.append((char)c);
			} while ((c = read()) > 10);
			return sb.toString();
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

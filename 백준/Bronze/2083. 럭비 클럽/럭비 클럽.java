import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		String name;

		while (!(name = reader.nextString()).equals("#")) {
			int age = reader.nextInt();
			int weight = reader.nextInt();

			if (age > 17 || weight >= 80) {
				sb.append(name).append(' ').append("Senior").append('\n');
			} else {
				sb.append(name).append(' ').append("Junior").append('\n');
			}
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

		String nextString() throws IOException {
			StringBuilder sb = new StringBuilder();
			byte c;
			while ((c = read()) <= 32)
				;
			do {
				sb.append((char)c);
			} while ((c = read()) > 32);
			return sb.toString();
		}
	}
}

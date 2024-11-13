import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int t = reader.nextInt();
		for (int i = 0; i < t; i++) {
			int[] input = new int[4];
			for (int j = 0; j < 4; j++) {
				input[j] = reader.nextInt();
			}

			boolean result = true;
			for (int j = 0; j < 3; j++) {
				result = true;
				int bit = (input[0] >> j) & 1;
				for (int k = 1; k < 4; k++) {
					if (((input[k] >> j) & 1) != bit) {
						result = false;
						break;
					}
				}
				if (result)
					break;
			}
			sb.append(result ? "YES\n" : "NO\n");
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

		char nextChar() throws IOException {
			byte c;
			while ((c = read()) <= 32)
				;
			return (char)c;
		}
	}
}

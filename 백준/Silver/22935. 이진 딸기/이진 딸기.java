import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();

		int t = reader.nextInt();

		for (int i = 0; i < t; i++) {
			int n = reader.nextInt() - 1;
			int bit = 0;

			int cycle = n / 14;
			if (cycle % 2 == 0) {
				bit = 1 + n % 14;
			} else {
				bit = 15 - n % 14;
			}

			for (int j = 3; j >= 0; j--) {
				int k = 1 << j;
				if ((bit & k) == k)
					sb.append("딸기");
				else
					sb.append('V');
			}

			sb.append('\n');
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

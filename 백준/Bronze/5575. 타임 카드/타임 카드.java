import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			int[] start = {reader.nextInt(), reader.nextInt(), reader.nextInt()};
			int[] end = {reader.nextInt(), reader.nextInt(), reader.nextInt()};

			int s = end[2] - start[2];
			if (s < 0) {
				end[1]--;
				s += 60;
			}
			int m = end[1] - start[1];
			if (m < 0) {
				end[0]--;
				m += 60;
			}
			int h = end[0] - start[0];
			sb.append(h).append(' ').append(m).append(' ').append(s).append('\n');
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

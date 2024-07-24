import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int[] round = {30001, 4500, 1000, 25};

		for (int i = 1; i <= n; i++) {
			int ranking = reader.nextInt();

			sb.append("Case #").append(i);

			if (ranking <= 25) {
				sb.append(": World Finals\n");
				continue;
			}

			for (int j = 0; j <= 3; j++) {
				if (ranking > round[j]) {
					sb.append(": Round ")
						.append(j)
						.append('\n');
					break;
				}
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
	}
}

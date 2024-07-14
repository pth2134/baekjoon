import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int t = reader.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int n = reader.nextInt();

			char[][] arr = new char[2][n];

			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < n; k++) {
					arr[j][k] = reader.nextChar();
				}
			}

			int b_cnt = 0; //원본과 다르면서 B인 갯수
			int w_cnt = 0;

			for (int j = 0; j < n; j++) {
				if (arr[0][j] == arr[1][j])
					continue;
				if (arr[1][j] == 'B')
					b_cnt++;
				else
					w_cnt++;
			}

			sb.append(Math.max(b_cnt, w_cnt)).append('\n');
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

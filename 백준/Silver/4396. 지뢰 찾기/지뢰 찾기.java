import java.io.IOException;

public class Main {
	static int[] x_move = {0, 0, -1, 1, -1, 1, -1, 1};
	static int[] y_move = {1, -1, 0, 0, 1, 1, -1, -1};

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[n + 2][n + 2];
		boolean[][] check = new boolean[n + 1][n + 1];

		boolean bomb = false;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				char c = reader.nextChar();
				if (c == '*') {
					map[i][j] = -10;
					for (int k = 0; k < 8; k++) {
						map[i + y_move[k]][j + x_move[k]]++;
					}
				}

			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				check[i][j] = reader.nextChar() == 'x';
				if (check[i][j] && map[i][j] < 0)
					bomb = true;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				if (check[i][j]) {
					int spot = map[i][j];
					if (spot >= 0) {
						sb.append(spot);
					} else {
						bomb = true;
						sb.append('*');
					}
					continue;
				}

				if (bomb && map[i][j] < 0) {
					sb.append('*');
					continue;
				}

				sb.append('.');

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

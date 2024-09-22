import java.io.IOException;

public class Main {
	static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //북, 동, 남, 서

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		String str = reader.nextString();
		boolean[][] map = new boolean[101][101];

		int up = 50;
		int down = 50;
		int left = 50;
		int right = 50;

		int y = 50;
		int x = 50;
		int dir = 2; //남쪽
		map[y][x] = true;

		for (int i = 0; i < n; i++) {
			char c = str.charAt(i);
			switch (c) {
				case 'F':
					y += move[dir][0];
					x += move[dir][1];
					map[y][x] = true;
					up = Math.max(up, y);
					down = Math.min(down, y);
					left = Math.min(left, x);
					right = Math.max(right, x);
					break;
				case 'R':
					dir = ++dir % 4;
					break;
				case 'L':
					dir = (dir + 3) % 4;
					break;
			}
		}

		for (int i = down; i <= up; i++) {
			for (int j = left; j <= right; j++) {
				sb.append(map[i][j] ? '.' : '#');
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

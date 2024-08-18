import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int[] c_move = {0, 0, -1, 1};
	static int[] r_move = {1, -1, 0, 0};
	static char[][] dots;
	static int[][] visited;
	static boolean circle = false;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		n = reader.nextInt();
		m = reader.nextInt();
		dots = new char[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dots[i][j] = reader.nextChar();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				char c = dots[i][j];
				if (visited[i][j] == 0) {
					visited[i][j] = 1;
					dfs(1, i, j, c);
					if (circle) {
						System.out.println("Yes");
						return;
					}
				}

			}
		}
		System.out.println("No");

	}

	static void dfs(int depth, int r, int c, char color) {
		for (int i = 0; i < 4; i++) {
			int r2 = r + r_move[i];
			int c2 = c + c_move[i];

			if (r2 >= 0 && r2 < n && c2 >= 0 && c2 < m && dots[r2][c2] == color) {
				if (visited[r2][c2] == 0) {
					visited[r2][c2] = depth + 1;
					dfs(depth + 1, r2, c2, color);
					continue;
				}

				if (Math.abs(visited[r2][c2] - depth) > 2) {
					circle = true;
				}

			}
		}
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

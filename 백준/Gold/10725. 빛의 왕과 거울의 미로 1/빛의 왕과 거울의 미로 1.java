import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static int[] r_move = {1, -1, 0, 0};
	static int[] c_move = {0, 0, -1, 1};
	static Map<Character, int[]> map = new HashMap<>();
	static int n;
	static int m;
	static int[] end_block;
	static char[][] mirrors;
	static int q_cnt = 0;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		n = reader.nextInt();
		m = reader.nextInt();
		int x = reader.nextInt();
		int y = reader.nextInt();
		int start_direction;
		int[] start_block;

		map.put('.', new int[] {1, 0, 3, 2});
		map.put('\\', new int[] {3, 2, 1, 0});
		map.put('/', new int[] {2, 3, 0, 1});

        if (x <= m) {
			start_block = new int[] {n - 1, x - 1};
			start_direction = 0; //상
		} else if (x <= m + n) {
			start_block = new int[] {n - (x - m), 0};
			start_direction = 2; //좌
		} else if (x <= m + n + n) {
			start_block = new int[] {n - (x - m - n), m - 1};
			start_direction = 3; //우
		} else {
			start_block = new int[] {0, x - m - n - n - 1};
			start_direction = 1; //하
		}

		if (y <= m) {
			end_block = new int[] {n, y - 1};
		} else if (y <= m + n) {
			end_block = new int[] {n - (y - m), -1};
		} else if (y <= m + n + n) {
			end_block = new int[] {n - (y - m - n), m};
		} else {
			end_block = new int[] {-1, y - m - n - n - 1};
		}
        
		mirrors = new char[n][m];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				mirrors[i][j] = reader.nextChar();
				if (mirrors[i][j] == '?')
					q_cnt++;
			}
		}

		dfs(start_block[0], start_block[1], start_direction, 0, mirrors[start_block[0]][start_block[1]]);

		System.out.println(answer);
	}

	static public void dfs(int row, int col, int direction, int cnt, char mirror) {
		if (mirror != '?') {
			int d = map.get(mirror)[direction];
			int row2 = row + r_move[d];
			int col2 = col + c_move[d];
			if (row2 >= 0 && row2 < n && col2 >= 0 && col2 < m) {
				//다음 위치 설정
				dfs(row2, col2, d % 2 == 0 ? d + 1 : d - 1, cnt, mirrors[row2][col2]);
				return;
			}

			if (row2 == end_block[0] && col2 == end_block[1]) {
				int numberCase = 1;
				while (++cnt <= q_cnt) {
					numberCase *= 3;
					numberCase %= 10_007;
				}

				answer += numberCase;
				answer %= 10_007;
			}

		} else {
			mirrors[row][col] = '.';
			dfs(row, col, direction, cnt + 1, '.');
			mirrors[row][col] = '/';
			dfs(row, col, direction, cnt + 1, '/');
			mirrors[row][col] = '\\';
			dfs(row, col, direction, cnt + 1, '\\');
			mirrors[row][col] = '?';
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

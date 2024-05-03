import java.util.HashSet;
import java.util.Set;

public class Main {
	static int n;
	static boolean[][] board;
	static Set<Integer> rowSet = new HashSet<>();
	static Set<Integer> columnSet = new HashSet<>();
	static int blackCnt = 0;
	static int whiteCnt = 0;

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		n = reader.nextInt();
		board = new boolean[2 * n - 1][2 * n - 1]; //board를 시계방향 45도 회전

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int row = i + j;
				board[row][n - 1 - i + j] = reader.nextInt() == 1;
			}
		}

		checkVishopBlack(0, 0);
		checkVishopWhite(1, 0);

		System.out.println(blackCnt + whiteCnt);
	}

	public static void checkVishopBlack(int row, int cnt) {
		if (row > 2 * n - 2) {
			blackCnt = Math.max(blackCnt, cnt);
			return;
		}

		int start = Math.abs(n - 1 - row);
		int end = 2 * n - 1 - start;
		for (int column = start; column < end; column += 2) {
			if (!board[row][column])
				continue;
			if (rowSet.contains(row) || columnSet.contains(column))
				continue;

			rowSet.add(row);
			columnSet.add(column);
			checkVishopBlack(row + 2, cnt + 1);
			rowSet.remove(row);
			columnSet.remove(column);
		}
		checkVishopBlack(row + 2, cnt);
	}

	public static void checkVishopWhite(int row, int cnt) {
		if (row > 2 * n - 3) {
			whiteCnt = Math.max(whiteCnt, cnt);
			return;
		}

		int start = Math.abs(n - 1 - row);
		int end = 2 * n - 1 - start;
		for (int column = start; column < end; column += 2) {
			if (!board[row][column])
				continue;
			if (rowSet.contains(row) || columnSet.contains(column))
				continue;

			rowSet.add(row);
			columnSet.add(column);
			checkVishopWhite(row + 2, cnt + 1);
			rowSet.remove(row);
			columnSet.remove(column);
		}
		checkVishopWhite(row + 2, cnt);
	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

		int nextInt() throws Exception {
			int n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			boolean neg = c == '-' ? true : false;
			if (neg)
				c = read();
			do
				n = (n << 3) + (n << 1) + (c & 15);
			while (isNumber(c = read()));
			return neg ? -n : n;
		}

		boolean isNumber(byte c) {
			return 47 < c && c < 58;
		}

		byte read() throws Exception {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}

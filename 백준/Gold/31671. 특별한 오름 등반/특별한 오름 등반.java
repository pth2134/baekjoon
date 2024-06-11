import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int m = reader.nextInt();

		int[] max_height = new int[2 * n + 2];
		for (int i = 0; i <= n; i++) {
			max_height[i] = i;
		}

		for (int i = n + 1; i <= 2 * n; i++) {
			max_height[i] = 2 * n - i;
		}

		int[][] visited = new int[2 * n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int x = reader.nextInt();
			int y = reader.nextInt();
			visited[x][y] = 1001;
		}

		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {0, 0, 1});
		int max = -1;

		while (!que.isEmpty()) {
			int[] poll = que.poll();
			int x = poll[0] + 1;
			int y1 = poll[1] + 1;
			int y2 = poll[1] - 1;
			int achieve = poll[2];

			int height = max_height[x];
			if (y1 <= height && (visited[x][y1] == 0 || visited[x][y1] < achieve)) {
				visited[x][y1] = Math.max(achieve, y1);
				que.add(new int[] {x, y1, visited[x][y1]});
			}

			if (y2 >= 0 && visited[x][y2] < achieve) {
				visited[x][y2] = achieve;
				que.add(new int[] {x, y2, achieve});
				if (x == 2 * n)
					max = Math.max(max, achieve);
			}
		}

		System.out.println(max);
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

		long nextLong() throws IOException {
			long n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			boolean neg = c == '-' ? true : false;
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

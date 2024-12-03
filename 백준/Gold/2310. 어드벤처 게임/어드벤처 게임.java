import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n;

		while ((n = reader.nextInt()) != 0) {
			List<Integer>[] maze = new List[n + 1];
			char[] detail = new char[n + 1];
			int[] cost = new int[n + 1];

			maze[0] = new ArrayList<>();
			maze[0].add(1);
			for (int i = 1; i <= n; i++) {
				List<Integer> room = new ArrayList<>();
				maze[i] = room;
				detail[i] = reader.nextChar();
				cost[i] = reader.nextInt();
				int input;
				while ((input = reader.nextInt()) != 0) {
					room.add(input);
				}
			}

			int[] visited = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				visited[i] = -1;
			}

			Queue<int[]> que = new LinkedList<>();
			que.add(new int[] {0, 0});
			while (!que.isEmpty()) {
				int r = que.peek()[0];
				int c = que.poll()[1];

				List<Integer> room = maze[r];
				for (Integer next : room) {
					int c2 = c;
					if (detail[next] == 'L')
						c2 = Math.max(c2, cost[next]);
					else if (detail[next] == 'T')
						c2 -= cost[next];
					if (c2 > visited[next]) {
						visited[next] = c2;
						que.add(new int[] {next, c2});
					}
				}
			}

			if (visited[n] >= 0)
				sb.append("Yes\n");
			else
				sb.append("No\n");
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

		char nextChar() throws IOException {
			byte c;
			while ((c = read()) <= 32)
				;
			return (char)c;
		}
	}
}

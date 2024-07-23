import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Queue<Integer> que;
	static boolean[] visited;
	static int[] color;
	static boolean possibe;
	static Queue<Integer>[] edgesArr;

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int t = reader.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int n = reader.nextInt();
			int m = reader.nextInt();

			edgesArr = new Queue[n + 1];
			for (int j = 1; j <= n; j++) {
				edgesArr[j] = new LinkedList<>();
			}

			for (int j = 0; j < m; j++) {
				int a = reader.nextInt();
				int b = reader.nextInt();

				edgesArr[a].add(b);
				edgesArr[b].add(a);
			}

			que = new LinkedList<>();
			visited = new boolean[n + 1];
			color = new int[n + 1];
			possibe = true;

			for (int j = 1; j <= n; j++) {
				if (!visited[j]) {
					visited[j] = true;
                    color[j] = 1;
					que.add(j);
					possibe = bfs();
				}

				if (!possibe)
					break;
			}

			sb.append(possibe ? "possible\n" : "impossible\n");
		}

		System.out.println(sb);
	}

	static boolean bfs() {
		while (!que.isEmpty()) {
			int a = que.poll();
			Queue<Integer> edgeQue = edgesArr[a];
			int size = edgeQue.size();

			for (int k = 0; k < size; k++) {
				int b = edgeQue.poll();
				if (!visited[b]) {
					color[b] = color[a] % 2 + 1;
					visited[b] = true;
					que.add(b);
				} else {
					if (color[a] == color[b]) {
						return false;
					}
				}
			}

		}

		return true;
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

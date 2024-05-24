import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int[] depth;
	static int[] parent;
	static int[] distance;
	static List<int[]>[] edgeList;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();

		int n = reader.nextInt();
		depth = new int[n + 1];
		parent = new int[n + 1];
		distance = new int[n + 1];
		edgeList = new LinkedList[n + 1];

		for (int i = 0; i <= n; i++) {
			edgeList[i] = new LinkedList<>();
		}

		for (int i = 1; i < n; i++) {
			int a = reader.nextInt();
			int b = reader.nextInt();
			int dist = reader.nextInt();
			edgeList[a].add(new int[] {b, dist});
			edgeList[b].add(new int[] {a, dist});
		}

		boolean[] visited = new boolean[n + 1];
		Queue<Integer> que = new LinkedList<>();
		que.add(1);
		visited[1] = true;

		while (!que.isEmpty()) {
			int node = que.poll();
			int next_depth = depth[node] + 1;
			for (int[] edge : edgeList[node]) {
				int child = edge[0];
				int dist = edge[1];

				if (visited[child])
					continue;

				visited[child] = true;
				depth[child] = next_depth;
				parent[child] = node;
				distance[child] = dist;
				que.add(child);
			}
		}

		int m = reader.nextInt();

		for (int i = 0; i < m; i++) {
			int a = reader.nextInt();
			int b = reader.nextInt();

			if (depth[a] < depth[b]) {
				int temp = a;
				a = b;
				b = temp;
			}

			int dist = 0;

			while (depth[a] > depth[b]) {
				dist += distance[a];
				a = parent[a];
			}

			while (a != b) {
				dist += distance[a] + distance[b];
				a = parent[a];
				b = parent[b];
			}

			sb.append(dist).append("\n");
		}

		System.out.println(sb);

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
			boolean neg = c == '-';
			if (neg)
				c = read();
			do
				n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
			return neg ? -n : n;
		}

		long nextLong() throws Exception {
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

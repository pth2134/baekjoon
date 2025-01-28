import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();

		int n = reader.nextInt();
		int m = reader.nextInt();
		int k = reader.nextInt();

		int[] visited = new int[n + 1]; //node에 도달할 때 드는 코스트
		int[] parent = new int[n + 1];

		Queue<int[]>[] nodes = new Queue[n + 1];
		for (int i = 1; i <= n; i++) {
			nodes[i] = new LinkedList<>();
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		for (int i = 0; i < k; i++) {
			int power = reader.nextInt();
			visited[power] = 1;
			parent[power] = power;
			pq.add(new int[] {power, 1, power}); //power로 갈 때 드는 코스트를 1로 설정, 마지막에 빼줘야함
		}

		for (int i = 0; i < m; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();
			int w = reader.nextInt();

			nodes[u].add(new int[] {v, w});
			nodes[v].add(new int[] {u, w});
		}

		while (!pq.isEmpty()) {
			int u = pq.peek()[0];
			int w = pq.peek()[1];
			int from = pq.poll()[2];

			if (visited[u] != w)
				continue;
			parent[u] = parent[from];

			for (int[] edge : nodes[u]) {
				int v = edge[0];
				if (v == from)
					continue;

				int w1 = edge[1];
				if (parent[v] == parent[u] || visited[v] != 0 && visited[v] <= w1)
					continue;
				visited[v] = w1;
				pq.add(new int[] {v, w1, u});
			}
		}

		int total_cost = -k;

		for (int i = 1; i <= n; i++) {
			total_cost += visited[i];
		}

		System.out.println(total_cost);
	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

		byte read() throws IOException {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}

		boolean isNumber(byte c) {
			return 47 < c && c < 58;
		}

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
	}
}

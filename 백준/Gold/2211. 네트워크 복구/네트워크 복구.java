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

		Queue<int[]>[] queues = new Queue[n + 1];
		for (int i = 0; i <= n; i++) {
			queues[i] = new LinkedList<>();
		}

		for (int i = 0; i < m; i++) {
			int a = reader.nextInt();
			int b = reader.nextInt();
			int c = reader.nextInt();
			queues[a].add(new int[] {b, c});
			queues[b].add(new int[] {a, c});
		}

		int[] visited = new int[n + 1];
		visited[1] = -1;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

		for (int[] route : queues[1]) {
			pq.add(new int[] {1, route[0], route[1]});
		}

		int cnt = 0;
		while (!pq.isEmpty()) {
			int[] route = pq.poll();
			int a = route[0];
			int b = route[1];
			int c = route[2];
			if (visited[b] != 0 && visited[b] <= c)
				continue;
			cnt++;
			visited[b] = c;
			sb.append(a).append(' ').append(b).append('\n');

			for (int[] next : queues[b]) {
				int t = c + next[1];
				if (visited[next[0]] == 0 || visited[b] > t) {
					pq.add(new int[] {b, next[0], t});
				}
			}

		}

		System.out.println(cnt);
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
	}
}

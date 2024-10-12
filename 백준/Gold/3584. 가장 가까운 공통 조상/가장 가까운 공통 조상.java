import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int t = reader.nextInt();
		for (int i = 0; i < t; i++) {
			int n = reader.nextInt();
			int[][] tree = new int[n + 1][2]; // root, depth
			List<Queue<Integer>> list = new ArrayList<>();

			for (int j = 0; j <= n; j++) {
				list.add(new LinkedList<>());
			}

			for (int j = 1; j < n; j++) {
				int a = reader.nextInt();
				int b = reader.nextInt();
				list.get(a).add(b);
				tree[b][0] = a;
				tree[b][1] = 1;
			}

			int root = 0;

			for (int j = 1; j <= n; j++) {
				if (tree[j][1] == 0) {
					root = j;
					break;
				}
			}

			Queue<int[]> que = new LinkedList<>();
			que.add(new int[] {root, 0});
			while (!que.isEmpty()) {
				int node = que.peek()[0];
				int depth = que.poll()[1] + 1;
				Queue<Integer> edge = list.get(node);
				while (!edge.isEmpty()) {
					int next = edge.poll();
					tree[next][1] = depth;
					que.add(new int[] {next, depth});
				}
			}

			int a = reader.nextInt();
			int b = reader.nextInt();

			if (tree[a][1] > tree[b][1]) {
				int temp = a;
				a = b;
				b = temp;
			}

			int gap = tree[b][1] - tree[a][1];
			for (int j = 0; j < gap; j++) {
				b = tree[b][0];
			}

			while (a != b) {
				a = tree[a][0];
				b = tree[b][0];
			}

			sb.append(a).append('\n');
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
	}
}

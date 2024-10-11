import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int t = reader.nextInt();
		int w = reader.nextInt();

		Queue<int[]> que = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			que.add(new int[] {reader.nextInt(), reader.nextInt()});
		}

		int m = reader.nextInt();
		PriorityQueue<int[]> post = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

		for (int i = 0; i < m; i++) {
			post.add(new int[] {reader.nextInt(), reader.nextInt(), reader.nextInt()});
		}

		int time = 0;

		while (!que.isEmpty()) {
			int[] poll = que.poll();
			int id = poll[0];
			int tx = poll[1];
			int take = Math.min(t, tx);
			int last = Math.min(time + take, w);
			for (; time < last; time++) {
				sb.append(id).append('\n');
			}
			if (time >= w)
				break;
			while (!post.isEmpty() && post.peek()[2] <= time)
				que.add(post.poll());
			if (tx > t)
				que.add(new int[] {id, tx - t});
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

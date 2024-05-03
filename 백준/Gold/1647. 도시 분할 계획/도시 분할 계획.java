import java.util.PriorityQueue;

public class Main {
	static int[] union;

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int m = reader.nextInt();
		union = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			union[i] = i;
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

		for (int i = 0; i < m; i++) {
			int from = reader.nextInt();
			int to = reader.nextInt();
			int cost = reader.nextInt();

			pq.add(new int[] {from, to, cost});
		}

		int cnt = 0;
		int sum = 0;
		int max = 0;

		while (cnt < n - 1) {
			int[] poll = pq.poll();
			int a = unionFind(poll[0]);
			int b = unionFind(poll[1]);

			if (a == b)
				continue;

			if (b > a)
				union[b] = a;
			else
				union[a] = b;
			cnt++;
			sum += poll[2];
			max = Math.max(max, poll[2]);
		}

		System.out.println(sum - max);

	}

	public static int unionFind(int num) {
		if (union[num] != num)
			return union[num] = unionFind(union[num]);
		return num;
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
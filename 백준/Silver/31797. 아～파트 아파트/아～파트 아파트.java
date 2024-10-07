import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int m = reader.nextInt();
		int[] hands = new int[m * 2 + 1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		for (int i = 1; i <= m; i++) {
			pq.add(new int[] {reader.nextInt(), i});
			pq.add(new int[] {reader.nextInt(), i});
		}

		for (int i = 1; i <= 2 * m; i++) {
			hands[i] = pq.poll()[1];
		}

		int idx = n;
		idx %= 2 * m;
		if (idx == 0)
			idx = 2 * m;

		System.out.println(hands[idx]);

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

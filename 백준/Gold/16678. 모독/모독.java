import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			pq.add(reader.nextInt());
		}

		int minus = 1;
		long hacker = 0;

		while (!pq.isEmpty()) {
			int min = pq.poll();

			if (min > minus) {
				hacker += min - minus;
				minus++;
			} else if (min == minus) {
				minus++;
			}

		}

		System.out.println(hacker);

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

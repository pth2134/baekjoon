import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 0; i < 4; i++) {
			pq1.add(reader.nextInt());
		}
		for (int i = 0; i < 2; i++) {
			pq2.add(reader.nextInt());
		}
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += pq1.poll();
		}
		sum += pq2.poll();

		System.out.println(sum);
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

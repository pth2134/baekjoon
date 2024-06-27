import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int k = reader.nextInt();

		Queue<Integer> needJump = new LinkedList<>();

		for (int i = 1; i <= n - 1; i++) {
			int dist = reader.nextInt();
			if (dist > k)
				needJump.add(i);
		}

		int start = 0;
		int now = 0;
		int next = 0;
		int max = 0;

		if (needJump.size() >= 2) {
			start = needJump.poll();
			now = needJump.poll();
			max = now;
		}

		while (!needJump.isEmpty()) {
			next = needJump.poll();
			max = Math.max(max, next - start);

			start = now;
			now = next;
		}

		next = n;
		max = Math.max(max, next - start);

		System.out.println(max);

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

		long nextLong() throws IOException {
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

import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		PriorityQueue<Integer> jueon = new PriorityQueue<>();
		PriorityQueue<Integer> boss = new PriorityQueue<>();
		
		int n = reader.nextInt();

		for (int i = 0; i < n; i++) {
			jueon.add(reader.nextInt());
		}
		for (int i = 0; i < n; i++) {
			boss.add(reader.nextInt());
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int b = boss.poll();
			int j = jueon.peek();
			if (b > j) {
				cnt++;
				jueon.poll();
			}
		}

		if (2 * cnt >= n + 1) {
			System.out.println("YES");
		} else
			System.out.println("NO");
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

		char nextChar() throws IOException {
			byte c;
			while ((c = read()) <= 32)
				;
			return (char)c;
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

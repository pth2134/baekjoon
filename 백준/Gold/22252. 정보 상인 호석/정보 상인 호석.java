import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		Map<String, PriorityQueue<Integer>> map = new HashMap<>();
		int q = reader.nextInt();
		long k = 0;

		for (int i = 0; i < q; i++) {
			int cmd = reader.nextInt();
			String name = reader.nextString();
			PriorityQueue<Integer> m = map.computeIfAbsent(name, s -> new PriorityQueue<>((o1, o2) -> o2 - o1));
			if (cmd == 1) {
				int n = reader.nextInt();
				while (n-- > 0) {
					m.add(reader.nextInt());
				}
			} else {
				int input = Math.min(m.size(), reader.nextInt());
				while (input-- > 0) {
					k += m.poll();
				}
			}
		}

		System.out.println(k);
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

		String nextString() throws IOException {
			StringBuilder sb = new StringBuilder();
			byte c;
			while ((c = read()) <= 32)
				;
			do {
				sb.append((char)c);
			} while ((c = read()) > 32);
			return sb.toString();
		}
	}
}

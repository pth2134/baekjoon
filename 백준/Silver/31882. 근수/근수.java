import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		String str = reader.nextString();

		long cnt = 0;
		Queue<Long> que = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			char c = str.charAt(i);
			if (c == '2')
				cnt++;
			else if (cnt > 0) {
				que.add(cnt);
				cnt = 0;
			}
		}

		if (cnt > 0)
			que.add(cnt);

		long score = 0;

		while (!que.isEmpty()) {
			long p = que.poll();
			for (long i = 1; i <= p; i++) {
				score += i * (p - i + 1L);
			}
		}

		System.out.println(score);
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

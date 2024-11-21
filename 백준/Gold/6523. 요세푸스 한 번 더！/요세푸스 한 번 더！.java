import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		long n;
		while ((n = reader.nextLong()) != 0L) {
			long a = reader.nextLong();
			long b = reader.nextLong();
			Map<Long, Integer> map = new HashMap<>(1000000);
			long x = 0;
			map.put(x, 0);
			int start = 0;
			int last = 0;
			for (int i = 1; i <= n; i++) {
				x = (a * (x * x % n) + b) % n;
				if (map.containsKey(x)) {
					start = map.get(x);
					last = i;
					map = null;
					System.gc();
					break;
				}
				map.put(x, i);
			}
			System.out.println(n - last + start);
		}

		
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

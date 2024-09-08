import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();

		int n = reader.nextInt();

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int a = reader.nextInt();

			if (map.containsKey(a - 1)) {
				map.put(a, map.get(a - 1) + 1);
				map.remove(a - 1);
			} else {
				map.put(a, 1);
			}

		}

		int max = 0;

		for (int key : map.keySet()) {
			max = Math.max(max, map.get(key));
		}

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

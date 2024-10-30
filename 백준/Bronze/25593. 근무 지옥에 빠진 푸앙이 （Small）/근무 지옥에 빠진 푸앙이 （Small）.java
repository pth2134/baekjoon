import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();

		Map<String, Integer> map = new HashMap<>();
		int[] time = {4, 6, 4, 10};
		int max = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 7; k++) {
					String input = reader.nextString();
					if (input.equals("-"))
						continue;

					int t = map.getOrDefault(input, 0) + time[j];
					map.put(input, t);
				}
			}
		}

		for (int value : map.values()) {
			max = Math.max(max, value);
			min = Math.min(min, value);
		}

		if (max - min > 12)
			System.out.println("No");
		else
			System.out.println("Yes");
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

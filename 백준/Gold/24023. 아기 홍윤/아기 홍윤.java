import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int k = reader.nextInt();

		int k2 = k;
		int cnt = 1;
		while (k2 > 1) {
			k2 /= 2;
			cnt++;
		}
		int all_one = (1 << cnt) - 1;

		int inverted_k = all_one ^ k;

		int start = 1;
		int last = 0;
		int bit = 0;
		for (int i = 0; i < n; i++) {
			int input = reader.nextInt();
			if (input > k || (input & inverted_k) > 1) {
				bit = 0;
				start = i + 2;
				continue;
			}

			bit = (bit | input);
			if (bit == k) {
				last = i + 1;
				break;
			}

		}

		if (last == 0)
			System.out.println(-1);
		else
			System.out.println(start + " " + last);
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

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int k = reader.nextInt() / reader.nextInt();

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int t = reader.nextInt();
			int s = reader.nextInt();

			int tCnt = k / t;
			if (k % t != 0)
				tCnt++;

			int time = k + (tCnt - 1) * s;

			min = Math.min(min, time);

		}

		System.out.println(min);
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

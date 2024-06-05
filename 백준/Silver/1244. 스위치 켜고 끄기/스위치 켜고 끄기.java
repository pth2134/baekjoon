public class Main {
	static boolean[] sw;
	static int n;

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		n = reader.nextInt();
		sw = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			sw[i] = reader.nextInt() == 1;
		}

		int m = reader.nextInt();

		for (int i = 0; i < m; i++) {
			int gender = reader.nextInt();
			int k = reader.nextInt();
			if (gender == 1) {
				male(k);
			} else {
				female(k);
			}
		}

		if (n <= 20) {
			for (int i = 1; i <= n; i++) {
				sb.append(sw[i] ? 1 : 0).append(' ');
			}
		} else {
			int d = n / 20;
			for (int i = 0; i < d; i++) {
				int start = i * 20 + 1;
				int last = i * 20 + 20;
				for (int j = start; j <= last; j++) {
					sb.append(sw[j] ? 1 : 0).append(' ');
				}
				sb.append('\n');
			}
			for (int i = d * 20 + 1; i <= n; i++) {
				sb.append(sw[i] ? 1 : 0).append(' ');
			}
		}

		System.out.println(sb);
	}

	static void male(int k) {
		for (int i = k; i <= n; i += k) {
			sw[i] = !sw[i];
		}
	}

	static void female(int k) {
		sw[k] = !sw[k];
		int hi = k;
		int low = k;
		while (++hi <= n && --low >= 1) {
			if (sw[hi] == sw[low]) {
				sw[hi] = sw[low] = !sw[hi];
			} else {
				break;
			}
		}
	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

		int nextInt() throws Exception {
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

		long nextLong() throws Exception {
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

		byte read() throws Exception {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		long n = reader.nextLong();
		double r = Math.sqrt(n);
		long m = n;

		long gcd = 1;

		for (int i = 2; i <= r; i++) {
			if (m % i == 0) {
				int cnt = 0;
				while (m % i == 0) {
					m /= i;
					cnt++;
				}
				gcd *= Math.pow(i, cnt - 1) * (i - 1);
			}
		}

		if (m > 1) {
			gcd *= m - 1;
		}

		System.out.println(gcd);
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
			boolean neg = c == '-' ? true : false;
			if (neg)
				c = read();
			do
				n = (n << 3) + (n << 1) + (c & 15);
			while (isNumber(c = read()));
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
				n = (n << 3) + (n << 1) + (c & 15);
			while (isNumber(c = read()));
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



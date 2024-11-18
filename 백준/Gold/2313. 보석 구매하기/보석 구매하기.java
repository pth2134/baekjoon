import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		long total = 0;
		for (int i = 0; i < n; i++) {
			int l = reader.nextInt();
			int start = 1;
			long sum = 0;
			int maxStart = 1;
			int maxLast = 1;
			long maxSum = Long.MIN_VALUE;
			for (int j = 1; j <= l; j++) {
				sum += reader.nextLong();
				if (sum > maxSum) {
					maxStart = start;
					maxLast = j;
					maxSum = sum;
				} else if (sum == maxSum) {
					if (maxLast - maxStart > j - start) {
						maxStart = start;
						maxLast = j;
					}
				}
				if (sum <= 0) {
					start = j + 1;
					sum = 0;
				}

			}
			total += maxSum;
			sb.append(maxStart).append(' ').append(maxLast).append('\n');
		}
		System.out.println(total);
		System.out.println(sb);
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

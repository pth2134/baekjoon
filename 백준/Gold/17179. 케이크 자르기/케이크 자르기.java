import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int m = reader.nextInt();
		int l = reader.nextInt();

		int[] pic = new int[m + 2];

		for (int i = 1; i <= m; i++) {
			pic[i] = reader.nextInt();
		}
		pic[m + 1] = l;

		for (int i = 0; i < n; i++) {
			int q = reader.nextInt();
			int low = 1;
			int hi = l / (q + 1);
			while (low <= hi) {
				int mid = (low + hi) / 2;
				int cnt = 0;
				int pre = 0;
				for (int j = 1; j < m + 2; j++) {
					int now = pic[j] - pre;
					if (now >= mid) {
						cnt++;
						pre = pic[j];
					}
				}
				if (cnt >= q + 1)
					low = mid + 1;
				else
					hi = mid - 1;
			}
			sb.append(low - 1).append('\n');
		}
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

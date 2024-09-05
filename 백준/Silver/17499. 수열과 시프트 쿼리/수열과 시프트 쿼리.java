import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int m = reader.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = reader.nextInt();
		}

		int start = 0;

		for (int i = 0; i < m; i++) {
			int c = reader.nextInt();
			switch (c) {
				case 1:
					arr[(start + reader.nextInt() - 1) % n] += reader.nextInt();
					break;
				case 2:
					start -= reader.nextInt();
					start %= n;
					if (start < 0)
						start += n;
					break;
				case 3:
					start += reader.nextInt();
					start %= n;
					break;
			}
		}

		for (int i = 0; i < n; i++) {
			sb.append(arr[(start + i) % n]).append(' ');
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
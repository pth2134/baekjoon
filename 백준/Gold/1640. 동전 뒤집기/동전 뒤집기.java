import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int r = reader.nextInt();
		int c = reader.nextInt();

		int[] rows = new int[r];
		int[] columns = new int[c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (reader.nextChar() == '1') {
					rows[i]++;
					columns[j]++;
				}

			}
		}

		int or = 0;
		int oc = 0;

		for (int i = 0; i < r; i++) {
			if (rows[i] % 2 == 1)
				or++;
		}
		for (int i = 0; i < c; i++) {
			if (columns[i] % 2 == 1)
				oc++;
		}

		int er = r - or;
		int ec = c - oc;

		int answer = r + c;

		if (or % 2 == 1) {
			//oc도 홀수
			answer = Math.min(answer, or + ec);
			answer = Math.min(answer, er + oc);
		} else {
			answer = Math.min(answer, er + ec);
			answer = Math.min(answer, or + oc);
		}

		System.out.println(answer);

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

		char nextChar() throws IOException {
			byte c;
			while ((c = read()) <= 32)
				;
			return (char)c;
		}
	}
}

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		int s = reader.nextInt();
		int k = reader.nextInt();
		int h = reader.nextInt();
		if (s + k + h >= 100)
			System.out.println("OK");
		else {
			if (s < k && s < h) {
				System.out.println("Soongsil");
			} else if (k < s && k < h) {
				System.out.println("Korea");
			} else if (h < k && h < s) {
				System.out.println("Hanyang");
			}
		}

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

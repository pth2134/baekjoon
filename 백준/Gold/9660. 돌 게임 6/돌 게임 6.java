import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		long n = reader.nextLong();
		boolean[] skWin = {false, true, false, true, true, true, true};

		System.out.println(skWin[(int) (n % 7)] ? "SK" : "CY");
	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

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

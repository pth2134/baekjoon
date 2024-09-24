import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int m = reader.nextInt();

		boolean[] win = new boolean[101]; //받았을 때 이길 수 있는것

		win[2] = true;

		for (int i = 3; i <= 100; i++) {
			for (int j = 1; j < i; j++) {
				if (!win[j] && !win[i - j]) { //상대가 받았을 때 둘다 못 이겨야함
					win[i] = true;
					break;
				}
			}
		}

		System.out.println(win[n] || win[m] ? 'A' : 'B');
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

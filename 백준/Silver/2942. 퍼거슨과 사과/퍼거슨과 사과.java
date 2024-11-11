import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int r = reader.nextInt();
		int g = reader.nextInt();
		int gcd = gcd(r, g);
		int cap = (int)Math.sqrt(gcd);
		for (int i = 1; i < cap; i++) {
			if (gcd % i == 0) {
				int rev = gcd / i;
				sb.append(i).append(' ').append(r / i).append(' ').append(g / i).append('\n');
				sb.append(rev).append(' ').append(r / rev).append(' ').append(g / rev).append('\n');
			}
		}
		if (cap * cap == gcd)
			sb.append(cap).append(' ').append(r / cap).append(' ').append(g / cap).append('\n');
		else if (cap == 1) {
			sb.append(1).append(' ').append(r).append(' ').append(g).append('\n');
			sb.append(gcd).append(' ').append(r / gcd).append(' ').append(g / gcd).append('\n');
		} else if (gcd % cap == 0) {
			int rev = gcd / cap;
			sb.append(cap).append(' ').append(r / cap).append(' ').append(g / cap).append('\n');
			sb.append(rev).append(' ').append(r / rev).append(' ').append(g / rev).append('\n');
		}
		System.out.println(sb);
	}

	public static int gcd(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		if (a == b)
			return a;
		return gcd(a - b, b);
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

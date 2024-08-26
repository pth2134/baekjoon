import java.io.IOException;

public class Main {
	static int[] union;

		public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();

		union = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			union[i] = i;
		}

		for (int i = 0; i < n - 2; i++) {
			int a = reader.nextInt();
			int b = reader.nextInt();
			int union_a = unionFind(a);
			int union_b = unionFind(b);
			
			if (union_b == b) {
				union[union_b] = union_a;
				continue;
			}
			if (union_a == a) {
				union[a] = union_b;
				continue;
			}
				
			union[union_b] = union_a;
		}

		int u = unionFind(1);
		for (int i = 2; i <= n; i++) {
			if (unionFind(i) != u) {
				System.out.println(u + " " + i);
				return;
			}
		}

	}

	public static int unionFind(int a) {
		if (union[a] == a)
			return a;
		return union[a] = unionFind(union[a]);
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

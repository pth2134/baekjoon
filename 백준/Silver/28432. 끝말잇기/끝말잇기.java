import java.io.IOException;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		HashSet<String> words = new HashSet<>();
		int n = reader.nextInt();

		char pre = ' ';
		char pre_fixed = ' ';
		char next = ' ';
		int type = 0;

		for (int i = 0; i < n; i++) {
			String str = reader.nextString();
			words.add(str);
			if (str.equals("?")) {
				if (i == n - 1) {
					pre_fixed = pre;
					type = 2;
				} else {
					str = reader.nextString();
					next = str.charAt(0);
					words.add(str);
					
					if (i == 0) {
						type = 0;
					} else {
						pre_fixed = pre;
						type = 1;
					}

					i++;
				}
			}

			pre = str.charAt(str.length() - 1);
		}

		int m = reader.nextInt();
        
        if (n == 1) {
			System.out.println(reader.nextString());
			return;
		}

		for (int i = 0; i < m; i++) {
			String str = reader.nextString();
			if (words.contains(str))
				continue;

			boolean a = str.charAt(0) == pre_fixed;
			boolean b = str.charAt(str.length() - 1) == next;

			if (a) {
				if (type == 1) {
					if (b) {
						System.out.println(str);
						return;
					}
				} else {
					System.out.println(str);
					return;
				}
			} else if (b) {
				if (type == 0) {
					System.out.println(str);
					return;
				}

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

		String nextString() throws IOException {
			StringBuilder sb = new StringBuilder();
			byte c;
			while ((c = read()) <= 32)
				;
			do {
				sb.append((char)c);
			} while ((c = read()) > 32);
			return sb.toString();
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

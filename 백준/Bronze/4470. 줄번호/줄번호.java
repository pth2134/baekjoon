import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		for (int i = 1; i <= n; i++) {
			sb.append(i).append(". ").append(reader.nextLine()).append('\n');
		}
		System.out.println(sb);
	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

		byte read() throws IOException {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
 
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
        
		String nextLine() throws IOException {
			StringBuilder sb = new StringBuilder();
			byte c;
			if ((c = read()) <= 10)
				return "";
			do {
				sb.append((char)c);
			} while ((c = read()) > 10);
			return sb.toString();
		}
	}
}

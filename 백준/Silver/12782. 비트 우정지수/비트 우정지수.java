import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		for (int i = 0; i < n; i++) {
			String a = reader.nextString();
			String b = reader.nextString();
			int aCnt = 0; //a = 1, b= 0
			int bCnt = 0; //a = 0, b= 1
			for (int j = 0; j < a.length(); j++) {
				char ac = a.charAt(j);
				char bc = b.charAt(j);
				if (ac != bc) {
					if (ac == '1')
						aCnt++;
					if (bc == '1')
						bCnt++;
				}
			}

			int r = Math.min(aCnt, bCnt) + Math.abs(aCnt - bCnt);
			sb.append(r).append('\n');
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
	}
}

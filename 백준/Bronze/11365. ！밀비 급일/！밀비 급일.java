import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		String str;

		while (!(str = reader.nextLine()).equals("END")) {
			for (int i = str.length() - 1; i >= 0; i--) {
				sb.append(str.charAt(i));
			}
			sb.append('\n');
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

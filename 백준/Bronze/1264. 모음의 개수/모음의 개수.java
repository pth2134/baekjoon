import java.io.IOException;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

		String str;

		while (!(str = reader.nextLine()).equals("#")) {
			int cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				if (set.contains(str.charAt(i)))
					cnt++;
			}
			
			sb.append(cnt).append('\n');
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

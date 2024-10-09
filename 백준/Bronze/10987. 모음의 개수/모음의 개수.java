import java.io.IOException;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		String str = reader.nextString();
		Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (set.contains(str.charAt(i)))
				cnt++;
		}
		System.out.println(cnt);
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
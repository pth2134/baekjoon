import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int m = reader.nextInt();

		Map<String, String> words = new HashMap<>();

		for (int i = 0; i < n; i++) {
			words.put(reader.nextString(), reader.nextString());
		}

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < m; i++) {
			String str = reader.nextString();
			StringBuilder answer_i = new StringBuilder();
			int s = str.length();
			for (int j = 0; j < s; j++) {
				StringBuilder sb = new StringBuilder();
				
				for (int k = j; k < s; k++) {
					sb.append(str.charAt(k));
					String Q = sb.toString();
					if (words.containsKey(Q))
						answer_i.append(words.get(Q));
				}
			}

			if (answer_i.length() == 0) {
				answer.append(-1).append('\n');
				continue;
			}

			answer.append(answer_i).append('\n');
		}

		System.out.println(answer);
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

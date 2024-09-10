import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();

		int[][] first = new int[n][2];
		int[][] second = new int[n][2];
		String[] str = new String[n];

		for (int i = 0; i < n; i++) {
			str[i] = reader.nextString();

			first[i][0] = str[i].charAt(0);
			first[i][1] = i;
			second[i][0] = str[i].charAt(1);
			second[i][1] = i;
		}

		Arrays.sort(first, (o1, o2) -> o1[0] - o2[0]);
		Arrays.sort(second, (o1, o2) -> o1[0] - o2[0]);

		Set<Integer> set = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			int firstIdx = first[i][1];
			int secondIdx = second[i][1];

			for (int j = 0; j < n; j++) {
				if (first[i][0] < second[j][0])
					break;
				if (firstIdx == second[j][1])
					continue;
				set.add(first[i][0]);
                break;
			}

			for (int j = 0; j < n; j++) {
				if (second[i][0] < first[j][0])
					break;
				if (secondIdx == first[j][1])
					continue;
				set.add(second[i][0]);
                break;
			}
		}

		StringBuilder sb = new StringBuilder();

		sb.append(set.size()).append('\n');

		for (int num : set) {
			sb.append((char)num).append(' ');
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

		char nextChar() throws IOException {
			byte c;
			while ((c = read()) <= 32)
				;
			return (char)c;
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
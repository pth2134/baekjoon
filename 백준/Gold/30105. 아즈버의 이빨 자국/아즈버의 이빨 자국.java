import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int[] tooth = new int[n];
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			tooth[i] = reader.nextInt();
			set.add(tooth[i]);
		}

		Deque<Integer> answer = new ArrayDeque<>();

		for (int i = 1; i <= n / 2; i++) {
			int interval = tooth[i] - tooth[0];
			answer.add(interval);

			for (int j = 0; j < n; j++) {
				int x = tooth[j];
				if (!set.contains(x + interval) && !set.contains(x - interval)) {
					answer.pollLast();
					break;
				}
			}

		}

		sb.append(answer.size()).append('\n');

		while (!answer.isEmpty()) {
			sb.append(answer.pollFirst()).append(' ');
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
	}
}

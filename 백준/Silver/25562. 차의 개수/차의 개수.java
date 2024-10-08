import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int[] arr = new int[n];

		arr[0] = 1;
		int add = 1;
		Set<Integer> gap = new HashSet<>();

		for (int i = 1; i < n; i++) {
			while (true) {
				boolean pass = true;
				arr[i] = arr[i - 1] + add;
				for (int j = 1; j < i; j++) {
					if (gap.contains(arr[i] - arr[j])) {
						pass = false;
						break;
					}
				}
				add++;
				if (pass) {
					for (int j = 0; j < i; j++) {
						gap.add(arr[i] - arr[j]);
					}
					break;
				}
			}
		}

		sb.append(gap.size()).append('\n');
		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(' ');
		}
		sb.append('\n').append(n - 1).append('\n');
		for (int i = 1; i <= n; i++) {
			sb.append(i).append(' ');
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

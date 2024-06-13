import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int m = reader.nextInt();
		Set<Integer>[] lists = new HashSet[n + 1];
		for (int i = 0; i < n; i++) {
			lists[i] = new HashSet<>();
		}

		for (int i = 0; i < m; i++) {
			int a = reader.nextInt();
			int b = reader.nextInt();
			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			lists[a].add(b);
		}

		int cnt = 0;

		for (int i = 1; i <= n - 2; i++) {
			for (int j = i + 1; j <= n - 1; j++) {
				if (lists[i].contains(j))
					continue;
				Set<Integer> set = new HashSet<>();
				for (int k : lists[i]) {
					if (k > j)
						set.add(k);
				}
				set.addAll(lists[j]);
				cnt += n - j - set.size();
			}
		}

		System.out.println(cnt);
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

		long nextLong() throws IOException {
			long n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			boolean neg = c == '-' ? true : false;
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

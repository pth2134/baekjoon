import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int m = reader.nextInt();
		int k = reader.nextInt();
		Set<Integer> set = new HashSet<>();
		Set<Integer> pos = new HashSet<>();
		int[][] transfer = new int[m][3];

		int origin = -1;

		for (int i = 0; i < k; i++) {
			int v = reader.nextInt();
			set.add(v);
			pos.add(v);
		}

		for (int i = 0; i < m; i++) {
			transfer[i][0] = reader.nextInt();
			transfer[i][1] = reader.nextInt();
			transfer[i][2] = reader.nextInt();
		}

		Arrays.sort(transfer, (o1, o2) -> o1[0] - o2[0]);

		for (int computer : set) {
			if (!pos.contains(computer))
				continue;

			Set<Integer> infected = new HashSet<>();
			infected.add(computer);

			for (int i = 0; i < m; i++) {
				int a = transfer[i][1];
				int b = transfer[i][2];

				if (!infected.contains(a))
					continue;

				if (!set.contains(b)) {
					pos.remove(a);
					pos.remove(computer);
					break;
				}

				infected.add(b);
			}

			if (infected.size() == set.size()) {
				origin = computer;
				break;
			}
		}

		System.out.println(origin);
	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

		int nextInt() throws Exception {
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

		long nextLong() throws Exception {
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

		byte read() throws Exception {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}

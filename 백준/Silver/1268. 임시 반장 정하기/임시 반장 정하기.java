import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();

		int[][] arr = new int[n + 1][6];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 5; j++) {
				arr[i][j] = reader.nextInt();
			}
		}

		int boss = 1;
		int max = 0;

		for (int i = 1; i <= n; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = 1; j <= 5; j++) {
				int my = arr[i][j];
				for (int k = 1; k < i; k++) {
					if (arr[k][j] == my)
						set.add(k);
				}
				for (int k = i + 1; k <= n; k++) {
					if (arr[k][j] == my)
						set.add(k);
				}
			}

			if (set.size() > max) {
				max = set.size();
				boss = i;
			}
		}

		System.out.println(boss);

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

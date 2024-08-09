import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();

		Set<Integer> set = new HashSet<>();
		int range = n * n;
		int fixed = n * (n * n + 1) / 2;

		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int a = reader.nextInt();

				if (set.contains(a) || a < 1 || a > range) {
					System.out.println("FALSE");
					return;
				}
				set.add(a);

				matrix[i][j] = a;
			}
		}

		for (int i = 0; i < n; i++) {
			int sum_r = 0;
			int sum_c = 0;
			for (int j = 0; j < n; j++) {
				sum_r += matrix[i][j];
				sum_c += matrix[j][i];
			}
			if (sum_r != fixed || sum_c != fixed) {
				System.out.println("FALSE");
				return;
			}
		}

		int sum_es = 0;
		int sum_en = 0;

		for (int i = 0; i < n; i++) {
			sum_es += matrix[i][i];
			sum_en += matrix[n - 1 - i][i];
		}

		if (sum_es != fixed || sum_en != fixed) {
			System.out.println("FALSE");
			return;
		}

		System.out.println("TRUE");
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

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int lastIncrease = -1;
		int[] arr = new int[n];
		boolean[] check = new boolean[n + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = reader.nextInt();
		}

		for (int i = 0; i < n - 1; i++) {
			if (arr[i + 1] > arr[i])
				lastIncrease = i;
		}

		if (lastIncrease == -1) {
			System.out.println(-1);
			return;
		}

		for (int i = 0; i < lastIncrease; i++) {
			check[arr[i]] = true;
			sb.append(arr[i]).append(' ');
		}

		for (int i = arr[lastIncrease] + 1; i <= n; i++) {
			if (!check[i]) {
				sb.append(i).append(' ');
				check[i] = true;
				for (int j = 1; j <= n; j++) {
					if (!check[j])
						sb.append(j).append(' ');
				}
				break;
			}
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

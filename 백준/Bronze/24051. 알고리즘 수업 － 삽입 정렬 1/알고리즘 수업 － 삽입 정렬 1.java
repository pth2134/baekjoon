import java.io.IOException;

public class Main {
	static int k;

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		k = reader.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = reader.nextInt();
		}

		System.out.println(insertion_sort(arr));
	}

	public static int insertion_sort(int[] arr) {
		int cnt = 0;

		for (int i = 1; i < arr.length; i++) {
			int loc = i - 1;
			int newItem = arr[i];

			while (0 <= loc && newItem < arr[loc]) {
				if (++cnt == k)
					return arr[loc];
				arr[loc + 1] = arr[loc];
				loc--;
			}
			if (loc + 1 != i) {
				if (++cnt == k)
					return newItem;
				arr[loc + 1] = newItem;
			}

		}

		return -1;
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

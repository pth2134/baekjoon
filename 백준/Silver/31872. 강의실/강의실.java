import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int k = reader.nextInt();

		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = reader.nextInt();
		}
		Arrays.sort(arr);

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
		boolean[] teleport = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			pq.add(new int[] {arr[i] - arr[i - 1], i});
		}

		for (int i = 0; i < k; i++) {
			teleport[pq.poll()[1]] = true;
		}

		int time = 0;
		int x = 0;
		for (int i = 0; i <= n; i++) {
			if (teleport[i]) {
				x = arr[i];
				continue;
			}

			time += arr[i] - x;
			x = arr[i];
		}

		System.out.println(time);

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

import java.io.IOException;

public class Main {
	static int count = 0;
	static int K;

	public static void heapSort(int[] li, int n) {
		buildMinHeap(li, n);
		for (int i = n; i > 1; i--) {
			// Swap li[1] and li[i]
			int temp = li[1];
			li[1] = li[i];
			li[i] = temp;

			count++;
			if (count == K) {
				System.out.println(li[i] + " " + li[1]);
				System.exit(0);
			}
			heapify(li, 1, i - 1);
		}
	}

	public static void buildMinHeap(int[] li, int n) {
		for (int i = n / 2; i > 0; i--) {
			heapify(li, i, n);
		}
	}

	public static void heapify(int[] li, int k, int n) {
		int left = 2 * k;
		int right = 2 * k + 1;
		int smaller;

		if (right <= n) {
			smaller = (li[left] < li[right]) ? left : right;
		} else if (left <= n) {
			smaller = left;
		} else {
			return;
		}

		if (li[smaller] < li[k]) {
			// Swap li[k] and li[smaller]
			int temp = li[k];
			li[k] = li[smaller];
			li[smaller] = temp;

			count++;
			if (count == K) {
				System.out.println(li[k] + " " + li[smaller]);
				System.exit(0);
			}
			heapify(li, smaller, n);
		}
	}

	public static void main(String[] args) throws IOException{
		Reader reader = new Reader();
		int n = reader.nextInt();
		K = reader.nextInt();
		int[] li = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			li[i] = reader.nextInt();
		}

		heapSort(li, n);
		System.out.println(-1);
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

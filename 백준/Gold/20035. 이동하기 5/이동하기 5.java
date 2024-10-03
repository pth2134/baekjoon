import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int m = reader.nextInt();

		int[] A = new int[n + 1];
		int[] B = new int[m + 1];
		int maxA = 0;
		int maxB = 0;
		Set<Integer> setA = new HashSet<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0])
				return o1[1] - o2[1];
			return o2[0] - o1[0];
		});
		for (int i = 1; i <= n; i++) {
			A[i] = reader.nextInt();
			if (A[i] > maxA) {
				setA.clear();
				setA.add(i);
				maxA = A[i];
			} else if (A[i] == maxA) {
				setA.add(i);
			}
		}
		for (int i = 1; i <= m; i++) {
			B[i] = reader.nextInt();
			pq.add(new int[] {B[i], i});
		}

		int r = 1;
		int c = 1;
		int candyA = 0;
		int candyB = 0;

		for (int i = 0; i < n + m - 2; i++) {
			candyA += A[r];
			candyB += B[c];
			if (!setA.contains(r)) {
				if (r == n) {
					c++;
					continue;
				}
				r++;
			} else {
				while (pq.peek()[1] < c)
					pq.poll();

				if (pq.peek()[0] <= B[c]) {
					if (r == n) {
						c++;
						continue;
					}
					if (setA.size() > 1 || c == m) {
						setA.remove(r);
						r++;
					} else {
						c++;
					}
				} else {
					if (c == m) {
						r++;
						continue;
					} else {
						c++;
					}
				}
			}
		}

		candyA += A[r];
		candyB += B[c];

		System.out.println((long)candyA * 1_000_000_000 + (long)candyB);
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

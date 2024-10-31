import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		PriorityQueue<int[]> npq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		PriorityQueue<int[]> mpq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

		int n = reader.nextInt();
		for (int i = 0; i < n; i++) {
			npq.add(new int[] {0, reader.nextInt(), reader.nextInt()});
		}
		int m = reader.nextInt();
		for (int i = 0; i < m; i++) {
			mpq.add(new int[] {reader.nextInt(), reader.nextInt(), reader.nextInt()});
		}

		int t = 0;

		while (!npq.isEmpty()) {
			int[] npeek = npq.peek();
			if (!mpq.isEmpty()) {
				int[] mpeek = mpq.peek();
				if (mpeek[0] <= t) {
					npq.add(mpq.poll());
					continue;
				} else if (mpeek[0] <= t + npeek[1]) {
					int take = t - mpeek[0];
					npeek[1] -= take;
					t += take;
					npq.add(mpq.poll());
					continue;
				}
			}
			t += npeek[1];
			if (t > npeek[2]) {
				System.out.println("NO");
				return;
			}
			npq.poll();
			if (npq.isEmpty() && !mpq.isEmpty()) {
                t = mpq.peek()[0];
				npq.add(mpq.poll());
			}
		}

		System.out.println("YES\n" + t);
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

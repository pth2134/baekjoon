import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int m = reader.nextInt();

		if (m == 0) {
			System.out.println("stay");
			return;
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		for (int i = 0; i < m; i++) {
			pq.add(new int[] {reader.nextInt(), reader.nextInt(), reader.nextInt()});
		}

		int nextX = pq.peek()[1];
		int nextY = pq.peek()[2];
		int fromTop = pq.poll()[0];
		int x = 0;
		int y = 0;

		
		if (fromTop == 1) {
			y -= nextX - x;
		} else
			y = Math.max(nextY + 1, y - (nextX - x));
		x = nextX;

		for (; x < n; x++) {
			if (nextX == x) { //끈끈이 주걱 위치에서 생존확인
				if (fromTop == 0 && y <= nextY) {
					System.out.println("adios");
					return;
				}
				if (fromTop == 1 && y >= nextY) {
					System.out.println("adios");
					return;
				}
			}

			//다음 끈끈이주걱으로부터 생존루트 확인
			if (pq.isEmpty()) {
				if (y > 0)
					y = Math.max(0, y - (n - x));
				else
					y = 0;
				break;
			} else {
				nextX = pq.peek()[1];
				nextY = pq.peek()[2];
				fromTop = pq.poll()[0];

				if (fromTop == 1) {
					y -= nextX - x;
				} else
					y = Math.max(nextY + 1, y - (nextX - x));
				x = nextX - 1;
			}
		}

		if (y == 0)
			System.out.println("stay");
		else
			System.out.println("adios");

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

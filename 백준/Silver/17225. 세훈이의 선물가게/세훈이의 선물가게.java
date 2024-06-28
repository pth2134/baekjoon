import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int a = reader.nextInt();
		int b = reader.nextInt();
		int n = reader.nextInt();
		int[][] order = new int[n][3];

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0])
				return o1[1] - o2[1]; //상민이 0, 지수가 1
			return o1[0] - o2[0];
		});

		int sm = 0;
		int js = 0;

		for (int i = 0; i < n; i++) {
			int time = reader.nextInt(); //시간
			int color = reader.nextChar(); //색깔
			int amount = reader.nextInt(); //개수
			if (color == 'B') {
				sm = Math.max(sm, time);
				while (amount-- > 0) {
					pq.add(new int[] {sm, 0});
					sm += a;
				}
			} else {
				js = Math.max(js, time);
				while (amount-- > 0) {
					pq.add(new int[] {js, 1});
					js += b;
				}
			}
		}

		Queue<Integer> sangmin = new LinkedList<>();
		Queue<Integer> jisoo = new LinkedList<>();

		int num = 1;

		while (!pq.isEmpty()) {
			if (pq.poll()[1] == 0)
				sangmin.add(num);
			else
				jisoo.add(num);

			num++;
		}

		sb.append(sangmin.size()).append('\n');
		while (!sangmin.isEmpty()) {
			sb.append(sangmin.poll()).append(' ');
		}
		sb.append('\n').append(jisoo.size()).append('\n');
		while (!jisoo.isEmpty()) {
			sb.append(jisoo.poll()).append(' ');
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

		char nextChar() throws IOException {
			byte c;
			while ((c = read()) <= 32)
				;
			return (char)c;
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

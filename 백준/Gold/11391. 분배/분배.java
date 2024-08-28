import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int k = reader.nextInt();
		int boxes = 1 << k;
		int perBox = 1 << (n - k);

		Queue<Integer>[] queList = new Queue[n + 1];

		for (int i = 0; i <= n; i++) {
			queList[i] = new LinkedList<>();
		}

		Queue<Integer>[] answer = new Queue[boxes];

		for (int i = 0; i < boxes; i++) {
			answer[i] = new LinkedList<>();
		}

		int low = 0;
		int hi;
		for (int i = 0; i <= n; i++) {
			hi = 1 << i;

			for (int j = low; j < hi; j++) {
				int cnt = 0;
				for (int l = 0; l < i; l++) {
					if ((j & (1 << l)) > 0)
						cnt++;
				}
				queList[cnt].add(j);
			}

			low = hi;
		}

		low = 0;
		hi = n;

		for (int i = 0; i < boxes; i++) {
			for (int j = 0; j < perBox / 2; j++) {
				if (queList[low].isEmpty()) {
					low++;
					hi--;
				}

				answer[i].add(queList[low].poll());
				answer[i].add(queList[hi].poll());
			}
		}

		for (int i = 0; i < boxes; i++) {
			Queue<Integer> que = answer[i];
			for (int j = 0; j < perBox; j++) {
				sb.append(que.poll()).append(' ');
			}
			sb.append('\n');
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

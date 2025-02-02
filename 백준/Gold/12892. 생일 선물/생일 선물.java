import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int d = reader.nextInt();
		Map<Integer, Long> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int key = reader.nextInt();
			map.put(key, map.getOrDefault(key, 0L) + reader.nextLong());
		}

		int size = map.size();
		Integer[] points = map.keySet().toArray(new Integer[size]);
		Arrays.sort(points);

		long sum = map.get(points[0]);
		long max = sum;
		Queue<Integer> que = new LinkedList<>();
		que.add(points[0]);

		for (int i = 1; i < size; i++) {
			int point = points[i];
			while (!que.isEmpty() && point - que.peek() >= d) {
				sum -= map.get(que.poll());
			}
			que.add(point);
			sum += map.get(point);
			max = Math.max(max, sum);
		}

		System.out.println(max);
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

		long nextLong() throws IOException {
			long n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			boolean neg = c == '-' ? true : false;
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

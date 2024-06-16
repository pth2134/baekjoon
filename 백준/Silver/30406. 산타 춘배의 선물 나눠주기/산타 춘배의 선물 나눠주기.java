import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int[] cost = new int[4];
		for (int i = 0; i < n; i++) {
			cost[reader.nextInt()]++;
		}

		int total = 0;
		//0,3 1,2 // 0,2 1,3 // 0,1 2,3
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int i = 0; i <= 3; i++) {
			map.put(i, new ArrayList<>());
		}
		List<int[]> list;
		list = map.get(3);
		list.add(new int[] {0, 3});
		list.add(new int[] {1, 2});
		list = map.get(2);
		list.add(new int[] {0, 2});
		list.add(new int[] {1, 3});
		list = map.get(1);
		list.add(new int[] {0, 1});
		list.add(new int[] {2, 3});

		for (int i = 3; i >= 1; i--) {
			for (int[] a : map.get(i)) {
				int b = a[0];
				int c = a[1];
				int min = Math.min(cost[b], cost[c]);
				cost[b] -= min;
				cost[c] -= min;
				total += i * min;
			}
		}

		System.out.println(total);

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

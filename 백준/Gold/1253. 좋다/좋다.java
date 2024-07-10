import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> arr_map = new HashMap<>();
		int[] arr = new int[n];
		boolean[] dup = new boolean[n];
		int cnt_0 = 0;
		for (int i = 0; i < n; i++) {
			int input = reader.nextInt();

			arr[i] = input;
			if (arr_map.containsKey(input)) {
				dup[i] = true;
				dup[arr_map.get(input)] = true;
			} else {
				arr_map.put(input, i);
			}
			if (arr[i] == 0)
				cnt_0++;
		}

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] == 0)
					continue;
				set.add(arr[i] + arr[j]);
			}
		}

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (set.contains(arr[i]))
				cnt++;
			else if (cnt_0 > 0 && dup[i]) {
				cnt++;
			}
		}

		if (!set.contains(0) && cnt_0 == 2) {
			cnt -= 2;
		}

		System.out.println(cnt);
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
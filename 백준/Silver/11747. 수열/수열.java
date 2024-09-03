import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();

		int[] arr = new int[n];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i <= 9; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			int input = reader.nextInt();
			arr[i] = input;
			map.get(input).add(i);
		}

		int start = 0;
		int last = 9;

		while (true) {
			for (int j = start; j <= last; j++) {
				String s = j + "";
				List<Integer> list = map.get(s.charAt(0) & 15);
				boolean exist = false;
				for (int i = 0; i < list.size(); i++) {
					if (exist)
						break;
					int idx = list.get(i);
					int k = 1;
					for (; k < s.length(); k++) {
						int idx2 = idx + k;
						if (idx2 >= n || (s.charAt(k) & 15) != arr[idx2])
							break;
					}
					if (k == s.length())
						exist = true;
				}
				if (!exist) {
					System.out.println(j);
					return;
				}
			}

			start = last + 1;
			last = (last << 3) + (last << 1) + 9;
		}

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

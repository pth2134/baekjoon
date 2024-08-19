import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();

		int[][] sky_value = new int[10][10];
		int[][] earth_value = new int[12][12];
		int[][] sky_earth = new int[60][60];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				sky_value[i][j] = reader.nextInt();
			}
		}

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				earth_value[i][j] = reader.nextInt();
			}
		}

		for (int i = 0; i < 10; i++) {
			int j = i % 2 == 0 ? 0 : 1;
			for (; j < 12; j += 2) {
				int r = i * 6 + j / 2;
				for (int k = 0; k < 10; k++) {
					int l = k % 2 == 0 ? 0 : 1;
					for (; l < 12; l += 2) {
						sky_earth[r][k * 6 + l / 2] = sky_value[i][k] + earth_value[j][l];
					}
				}
			}
		}

		List<Integer>[] lists = new List[60];
		for (int i = 0; i < 60; i++) {
			lists[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			int value = reader.nextInt();
			String str = reader.nextString();
			int sky = str.charAt(0) - '0';
			int earth = str.charAt(1) - 'A';

			int idx = sky * 6 + earth / 2;

			lists[idx].add(value);
		}

		for (int i = 0; i < 60; i++) {
			Collections.sort(lists[i], Collections.reverseOrder());
		}

		int max = 0;

		for (int i = 0; i < 60; i++) {
			if (lists[i].size() == 0)
				continue;

			int first = lists[i].get(0);

			if (lists[i].size() > 1) {
				int second = lists[i].get(1);

				if (lists[i].size() > 2) {
					int sum = first + second + lists[i].get(2);
					sum += sky_earth[i][i] * 3;
					max = Math.max(sum, max);
				}

				for (int j = i + 1; j < 60; j++) {
					if (lists[j].size() == 0)
						continue;

					int sum = first + second + lists[j].get(0);
					sum += sky_earth[i][j] * 2 + sky_earth[i][i];
					max = Math.max(sum, max);
				}
			}

			for (int j = i + 1; j < 60; j++) {
				if (lists[j].size() == 0)
					continue;
				int second = lists[j].get(0);

				if (lists[j].size() > 1) {
					int sum = first + second + lists[j].get(1);
					sum += sky_earth[i][j] * 2 + sky_earth[j][j];
					max = Math.max(sum, max);
				}

				for (int k = j + 1; k < 60; k++) {
					if (lists[k].size() == 0)
						continue;
					int sum = first + second + lists[k].get(0);
					sum += sky_earth[i][j] + sky_earth[i][k] + sky_earth[j][k];
					max = Math.max(sum, max);
				}
			}
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

		String nextString() throws IOException {
			StringBuilder sb = new StringBuilder();
			byte c;
			while ((c = read()) <= 32)
				;
			do {
				sb.append((char)c);
			} while ((c = read()) > 32);
			return sb.toString();
		}

	}
}

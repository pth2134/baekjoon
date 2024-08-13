import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

		public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int l = n / 5;
		boolean[][] signal = new boolean[5][l];

		Map<Integer, Integer> map = new HashMap<>();
		map.put(6, 4);
		map.put(8, 7);
		map.put(2, 8);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < l; j++) {
				signal[i][j] = reader.nextChar() == '#';
			}
		}

		for (int i = 0; i < l; i++) {
			int j = Math.min(i + 3, l);
			int bCnt = 0;
			int wCnt = 0;
            
			for (; i < j; i++) {
				int wCnt_i = 0;
				for (int k = 0; k < 5; k++) {
					if (!signal[k][i])
						wCnt_i++;
					else
						bCnt++;
				}
				if (wCnt_i == 5)
					break;
				wCnt += wCnt_i;
			}

			if (wCnt == 0) {
				if (bCnt == 5)
					sb.append(1);
				continue;
			}

			i--;

			if (wCnt == 3) {
				if (!signal[2][i - 1]) {
					sb.append(0);
				} else if (!signal[1][i]) {
					sb.append(6);
				} else
					sb.append(9);

				continue;
			}

			if (wCnt == 4) {
				if (!signal[3][i])
					sb.append(2);
				else if (!signal[1][i - 2])
					sb.append(3);
				else
					sb.append(5);

				continue;
			}

			sb.append(map.get(wCnt));

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

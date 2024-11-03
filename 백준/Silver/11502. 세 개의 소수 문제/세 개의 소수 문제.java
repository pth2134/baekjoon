import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int t = reader.nextInt();
		boolean[] pri = new boolean[1000];
		int[][] two = new int[1000][2];
		int[][] three = new int[1000][3];

		for (int i = 2; i < 1000; i++) {
			if (pri[i])
				continue;
			int n = i << 1;
			while (n < 1000) {
				pri[n] = true;
				n += i;
			}
		}

		for (int i = 2; i < 1000; i++) {
			if (pri[i])
				continue;
			for (int j = 2; j < 1000; j++) {
				if (pri[j])
					continue;
				if (i + j >= 1000)
					break;
				two[i + j][0] = i;
				two[i + j][1] = j;
			}
		}

		for (int i = 2; i < 1000; i++) {
			if (pri[i])
				continue;
			for (int j = 4; j < 1000; j++) {
				if (two[j][1] == 0)
					continue;
				int n = i + j;
				if (n >= 1000)
					break;
				if (three[n][2] != 0)
					continue;
				three[n][0] = two[j][0];
				three[n][1] = two[j][1];
				three[n][2] = i;
				Arrays.sort(three[i + j]);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int input = reader.nextInt();
			
			for (int j = 0; j < 3; j++) {
				sb.append(three[input][j]).append(' ');
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

import java.io.IOException;

public class Main {
	static int[][] number = new int[10][2];
	static int min_effort = Integer.MAX_VALUE;
	static int hours = 0;
	static int minutes = 0;

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		for (int i = 1; i < 10; i++) {
			number[i][0] = (i - 1) % 3;
			number[i][1] = (i - 1) / 3;
		}
		number[0][0] = 1;
		number[0][1] = 3;

		int h = reader.nextInt();
		int m = reader.nextInt();

		for (int hour = h; hour < 100; hour += 24) {
			cal_hour(hour, m, 0);
		}

		String time = String.format("%02d:%02d", hours, minutes);
		System.out.println(time);
	}

	static void cal_hour(int h, int m, int total_effort) {
		int e = total_effort + effort(h / 10, h % 10);

		for (int minute = m; minute < 100; minute += 60) {
			cal_minute(h, minute, e);
		}
	}

	static void cal_minute(int h, int m, int total_effort) {
		int e = total_effort + effort(h % 10, m / 10) + effort(m / 10, m % 10);

		if (min_effort > e) {
			hours = h;
			minutes = m;

			min_effort = e;
		}
	}

	static int effort(int a, int b) {
		return Math.abs(number[a][0] - number[b][0]) + Math.abs(number[a][1] - number[b][1]);
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

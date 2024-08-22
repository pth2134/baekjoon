import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		double[] juice = new double[3];
		double[] recipe = new double[3];

		for (int i = 0; i < 3; i++) {
			juice[i] = reader.nextInt();
		}
		for (int i = 0; i < 3; i++) {
			recipe[i] = reader.nextInt();
		}

		double min = 500;

		for (int i = 0; i < 3; i++) {
			min = Math.min(juice[i] / recipe[i], min);
		}

		for (int i = 0; i < 3; i++) {
			double value = juice[i] - recipe[i] * min;
			double intValue = Math.floor(value);
			if (value == intValue)
				sb.append((int)value);
			else
				sb.append(value);
			sb.append(' ');
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

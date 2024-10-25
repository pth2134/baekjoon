import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		int s = reader.nextInt();
		int sum = s % 4763 == 0 ? s / 4763 : -1;
		int cnt = 0;
		
		if(sum == 0) {
			System.out.println("1\n0 0");
			return;
		} else if (sum == -1) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i <= 200; i++) {
			int[] a = {i * 508, i * 108};

			for (int j = 0; j <= 200; j++) {
				int[] b = {j * 212, j * 305};

				for (int k = 0; k < 2; k++) {
					for (int l = 0; l < 2; l++) {
						if (a[k] + b[l] == sum) {
							cnt++;
							sb.append(i).append(' ').append(j).append('\n');
						}
					}
				}
			}
		}

		System.out.println(cnt);
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

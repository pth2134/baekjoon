import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int m = reader.nextInt();
		int k = reader.nextInt();

		int[] ani = new int[n];

		for (int i = 0; i < n; i++) {
			ani[i] = reader.nextInt();
		}

		Arrays.sort(ani);

		//k=3일 때, 7까지 볼 수 있다면 1 / 2 3 4 / 5 6 7 이렇게 맨 뒤에 있는 그룹은 가득차게 하는게 이득
		long[] pre = new long[k];
		for (int i = 1; i <= Math.min(n, k - 1); i++) {
			// 맨 앞 그룹에 i개가 있을 때 시간 총합 (뒤의 그룹은 가득참)
			pre[i] = ani[i - 1];

			if (ani[i - 1] > m) {
				System.out.println(i - 1);
				return;
			}

		}

		for (int i = k - 1; i < n; i++) {
			int first_cnt = (i + 1) % k;
			pre[first_cnt] = pre[first_cnt] + ani[i];

			if (pre[first_cnt] > m) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(n);
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

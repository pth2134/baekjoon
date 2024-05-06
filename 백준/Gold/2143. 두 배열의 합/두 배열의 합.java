import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		int t = reader.nextInt();
		int n = reader.nextInt();
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = a[i - 1] + reader.nextInt();
		}
		int m = reader.nextInt();
		int[] b = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			b[i] = b[i - 1] + reader.nextInt();
		}

		long cnt = 0L;

		Map<Integer, Integer> aMap = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				int aSum = a[i] - a[j];
				if (aMap.containsKey(aSum))
					aMap.replace(aSum, aMap.get(aSum) + 1);
				else
					aMap.put(aSum, 1);
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < i; j++) {
				int bSum = b[i] - b[j];
				if (aMap.containsKey(t - bSum))
					cnt += aMap.get(t - bSum);
			}
		}

		System.out.println(cnt);

	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

		int nextInt() throws Exception {
			int n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			boolean neg = c == '-' ? true : false;
			if (neg)
				c = read();
			do
				n = (n << 3) + (n << 1) + (c & 15);
			while (isNumber(c = read()));
			return neg ? -n : n;
		}

		boolean isNumber(byte c) {
			return 47 < c && c < 58;
		}

		byte read() throws Exception {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}

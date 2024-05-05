public class Main {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		int n = reader.nextInt();
		int s = reader.nextInt();

		int[] seq = new int[n];
		seq[0] = reader.nextInt();
		for (int i = 1; i < n; i++) {
			seq[i] = seq[i - 1] + reader.nextInt();
		}

		if (seq[n - 1] < s){
			System.out.println(0);
			return;	
		}

		int min = Integer.MAX_VALUE;
		int j = 0;

		for (int i = 0; i < n; i++) {
			if (seq[i] < s)
				continue;
			for (; j <= i; j++) {
				if (seq[i] - seq[j] < s) {
					min = Math.min(min, i - j + 1);
					break;
				}
			}
		}

		System.out.println(min);
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

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int l = reader.nextInt();

		boolean[] visited = new boolean[10];
		int pre = reader.nextInt();
		visited[pre] = true;
		boolean able = true;
		for (int i = 1; i < l; i++) {
			int input = reader.nextInt();
			if (visited[input]) {
				able = false;
				break;
			}
			visited[input] = true;
			int[] loc1 = loc(pre);
			int[] loc2 = loc(input);

			int x = loc1[0] + loc2[0];
			int y = loc1[1] + loc2[1];
			if (x % 2 == 0 && y % 2 == 0) {
				int m = val(x / 2, y / 2);
				if (!visited[m]) {
					able = false;
					break;
				}
			}

			pre = input;
		}
		System.out.println(able ? "YES" : "NO");
	}

	public static int[] loc(int a) {
		int x = a % 3;
		return new int[] {x == 0 ? 3 : x, (a - 1) / 3 + 1};
	}

	public static int val(int x, int y) {
		return x + (y - 1) * 3;
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

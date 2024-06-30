import java.io.IOException;

public class Main {
	static String str;
	static int n;
	static boolean[] visited;
	static int[] arr;
	static boolean check = false;
	static int legnth;

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		StringBuilder sb = new StringBuilder();
		str = reader.nextString();
		legnth = str.length();
		n = legnth;

		if (str.length() > 10) {
			n = (n - 9) / 2 + 9;
		}

		visited = new boolean[n + 1];
		arr = new int[n];

		visited[0] = true;
		build(0, 0);

		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(' ');
		}

		System.out.println(sb);

	}

	static void build(int idx, int order) {
		if (idx >= legnth) {
			if (arr[n - 1] > 0)
				check = true;
			return;
		}

		int a = str.charAt(idx) - 48;

		if (!visited[a]) {
			visited[a] = true;
			arr[order] = a;
			build(idx + 1, order + 1);
			visited[a] = false;
		}

		if (check)
			return;

		if (idx >= legnth - 1)
			return;

		int b = str.charAt(idx + 1) - 48;
		a = a * 10 + b;

		if (a > n)
			return;

		if (!visited[a]) {
			visited[a] = true;
			arr[order] = a;
			build(idx + 2, order + 1);

			if (!check)
				visited[a] = false;
		}

	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static int[][] dp;
	static Map<Integer, List<Integer>> map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		int n = reader.nextInt();
		dp = new int[n + 1][2];
		map = new HashMap<>();
		visited = new boolean[n + 1];
		for (int i = 1; i < n; i++) {
			int a = reader.nextInt();
			int b = reader.nextInt();
			if (!map.containsKey(a))
				map.put(a, new ArrayList<>());
			if (!map.containsKey(b))
				map.put(b, new ArrayList<>());

			map.get(a).add(b);
			map.get(b).add(a);
		}
		visited[1] = true;
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));

	}

	static void dfs(int k) {
		dp[k][0] = 0;
		dp[k][1] = 1;

		List<Integer> list = map.get(k);
		for (int i : list) {
			if (visited[i])
				continue;
			visited[i] = true;
			dfs(i);
			dp[k][0] += dp[i][1];
			dp[k][1] += Math.min(dp[i][0], dp[i][1]);
		}
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
			boolean neg = c == '-';
			if (neg)
				c = read();
			do
				n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
			return neg ? -n : n;
		}

		long nextLong() throws Exception {
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


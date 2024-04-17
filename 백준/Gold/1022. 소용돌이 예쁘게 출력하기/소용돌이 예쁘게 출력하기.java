import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		int[][] graph = new int[r2 - r1 + 1][c2 - c1 + 1];
		int longest = 0;

		for (int i = 0; i < graph.length; i++) {
			int y = i + r1;
			for (int j = 0; j < graph[0].length; j++) {
				int x = j + c1;
				int max = Integer.max(Math.abs(x), Math.abs(y));
				int length = 2 * max;
				int start = (int)Math.pow(2 * max + -1, 2);
				if (x == max || -x == max) {
					if (y == max || -y == max) {
						if (y < 0 && x > 0) {
							graph[i][j] = start + length;
						} else if (y < 0 && x < 0) {
							graph[i][j] = start + 2 * length;
						} else if (y > 0 && x < 0) {
							graph[i][j] = start + 3 * length;
						} else if (y > 0 && x > 0) {
							graph[i][j] = start + 4 * length;
						} else if (x == 0 && y == 0) {
							graph[i][j] = start;
						}
					} else if (x > 0) {
						graph[i][j] = start + max - y;
					} else {
						graph[i][j] = start + 2 * length + y + max;
					}
				} else {
					if (y < 0) {
						graph[i][j] = start + length + max - x;
					} else {
						graph[i][j] = start + 3 * length + x + max;
					}
				}
				longest = Integer.max(longest, graph[i][j]);
			}
		}

		longest = (int)(Math.log10(longest) + 1);

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				sb.append(String.format("%" + longest + "d", graph[i][j])).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
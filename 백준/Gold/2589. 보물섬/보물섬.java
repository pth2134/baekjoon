import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] isLand;
	static int max = 0;
	static int r;
	static int c;
	static int[] rMove = {1, -1, 0, 0};
	static int[] cMove = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		isLand = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				isLand[i][j] = br.read() == 'L';
			}
			br.read(); //줄바꿈
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (isLand[i][j]) {
					bfs(i, j);
				}
			}
		}

		System.out.println(max - 1);
	}

	private static void bfs(int i, int j) {
		int[][] visited = new int[r][c];
		Queue<Integer[]> que = new LinkedList<>();
		que.add(new Integer[] {i, j});
		visited[i][j] = 1;
		while (!que.isEmpty()) {
			Integer[] poll = que.poll();
			int from = visited[poll[0]][poll[1]];
			int to = from + 1;
			max = Integer.max(max, from);
			for (int k = 0; k < 4; k++) {
				int y = poll[0] + rMove[k];
				int x = poll[1] + cMove[k];
				if (y < r && x < c && y >= 0 && x >= 0 && isLand[y][x] && (visited[y][x] == 0
					|| visited[y][x] > to)) {
					visited[y][x] = to;
					que.add(new Integer[] {y, x});
				}
			}
		}
	}

}

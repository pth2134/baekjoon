import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] forest = new int[n][n];
		int[][] dp = new int[n][n];
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int input = Integer.parseInt(st.nextToken());
				forest[i][j] = input;
				pq.add(new Integer[] {input, i, j});
			}
		}

		for (int i = 0; i < n * n; i++) {
			Integer[] poll = pq.poll();
			int r = poll[1];
			int c = poll[2];
			for (int k = 0; k < 4; k++) {
				int y = r + dy[k];
				int x = c + dx[k];
				if (y >= 0 && x >= 0 && y < n && x < n) {
					if (forest[y][x] > forest[r][c] && dp[y][x] < dp[r][c] + 1) {
						dp[y][x] = dp[r][c] + 1;
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Integer.max(max, dp[i][j]);
			}
		}

		System.out.println(max + 1);
	}

}
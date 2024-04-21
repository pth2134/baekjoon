import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[][] isLand;
	static boolean[][] visited1;
	static int[][][] visited2;
	static Queue<Integer[]> que_forLand = new LinkedList<>();
	static Queue<Integer[]> que_forBridge = new LinkedList<>();
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		isLand = new boolean[n][n];
		visited1 = new boolean[n][n];
		visited2 = new int[n][n][2]; //[0] 거리 [1] 출발 섬 번호

		int landCnt = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				isLand[i][j] = st.nextToken().equals("1");
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isLand[i][j] && !visited1[i][j]) {
					landCnt++;
					visited2[i][j][1] = landCnt;
					que_forLand.add(new Integer[] {i, j});
					findLand(landCnt);
				}

			}
		}
		int min = Integer.MAX_VALUE;

		while (!que_forBridge.isEmpty()) {
			Integer[] poll = que_forBridge.poll();
			int d = visited2[poll[0]][poll[1]][0] + 1;
			int landNum = visited2[poll[0]][poll[1]][1];
			for (int i = 0; i < 4; i++) {
				int y = poll[0] + dy[i];
				int x = poll[1] + dx[i];
				if (y >= 0 && y < n && x >= 0 && x < n) {
					if (visited2[y][x][0] != 0) {
						if (visited2[y][x][1] != landNum) {
							min = Math.min(min, d + visited2[y][x][0]);
						}
					} else {
						if (isLand[y][x]) {
							if (visited2[y][x][1] != landNum) {
								min = Math.min(min, d);
							}
						} else {
							visited2[y][x][0] = d;
							visited2[y][x][1] = landNum;
							if (!isLand[y][x])
								que_forBridge.add(new Integer[] {y, x});
						}
					}

				}
			}
		}

		System.out.println(min - 1);
	}

	public static void findLand(int landCnt) {
		while (!que_forLand.isEmpty()) {
			Integer[] poll = que_forLand.poll();
			for (int i = 0; i < 4; i++) {
				int y = poll[0] + dy[i];
				int x = poll[1] + dx[i];
				if (y >= 0 && y < n && x >= 0 && x < n && !visited1[y][x]) {
					visited1[y][x] = true;
					if (isLand[y][x]) {
						que_forLand.add(new Integer[] {y, x});
						visited2[y][x][1] = landCnt;
					} else {
						que_forBridge.add(new Integer[] {y, x});
						visited2[y][x][0] = 1;
						visited2[y][x][1] = landCnt;
					}
				}
			}
		}
	}

}

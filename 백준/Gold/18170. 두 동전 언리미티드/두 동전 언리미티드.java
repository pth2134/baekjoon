import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] board = new char[m][n];
		boolean[][][][] visited = new boolean[m][n][m][n];
		Queue<Integer[]> que = new LinkedList<>();

		Integer[] coin = new Integer[5];
		coin[4] = 0;
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[j][i] = (char)br.read();
				if (board[j][i] == 'o') {
					coin[idx] = j;
					coin[idx + 1] = i;
					idx += 2;
				}
			}
			br.read();
		}
		visited[coin[0]][coin[1]][coin[2]][coin[3]] = true;
		visited[coin[2]][coin[3]][coin[0]][coin[1]] = true;
		que.add(coin);

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, 1, -1};

		while (!que.isEmpty()) {
			coin = que.poll();
			for (int i = 0; i < 4; i++) {
				Integer[] newCoin = new Integer[5];
				newCoin[4] = coin[4] + 1;
				int coin1X = coin[0] + dx[i];
				int coin1Y = coin[1] + dy[i];
				int coin2X = coin[2] + dx[i];
				int coin2Y = coin[3] + dy[i];
				boolean coin1 = coin1X >= 0 && coin1X < m && coin1Y >= 0 && coin1Y < n;
				boolean coin2 = coin2X >= 0 && coin2X < m && coin2Y >= 0 && coin2Y < n;
				if (coin1 && coin2) {
					if (board[coin1X][coin1Y] != '#') {
						newCoin[0] = coin1X;
						newCoin[1] = coin1Y;
					} else {
						newCoin[0] = coin[0];
						newCoin[1] = coin[1];
					}
					if (board[coin2X][coin2Y] != '#') {
						newCoin[2] = coin2X;
						newCoin[3] = coin2Y;
					} else {
						newCoin[2] = coin[2];
						newCoin[3] = coin[3];
					}
					if (!newCoin[0].equals(newCoin[2]) || !newCoin[1].equals(newCoin[3])) {
						if (!visited[newCoin[0]][newCoin[1]][newCoin[2]][newCoin[3]]) {
							visited[newCoin[0]][newCoin[1]][newCoin[2]][newCoin[3]] = true;
							visited[newCoin[2]][newCoin[3]][newCoin[0]][newCoin[1]] = true;
							que.add(newCoin);
						}
					}
				} else if (coin1 || coin2) {
					System.out.println(newCoin[4]);
					return;
				}
			}
		}

		System.out.println(-1);

	}

}

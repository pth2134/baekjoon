import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE; // 무한대 값을 나타내는 상수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 간선 수

		int[][] table = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					table[i][j] = 0;
				else
					table[i][j] = INF;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			table[v1][v2] = Math.min(table[v1][v2], cost);
			table[v2][v1] = Math.min(table[v2][v1], cost);
		}

		// 모든 노드 쌍에 대해 최단 거리를 계산 (플로이드-워셜 알고리즘)
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (table[i][k] != INF && table[k][j] != INF && table[i][j] > table[i][k] + table[k][j]) {
						table[i][j] = table[i][k] + table[k][j];
					}
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int pointJ = Integer.parseInt(st.nextToken()); // 지현이의 출발점
		int pointS = Integer.parseInt(st.nextToken()); // 성하의 출발점

		int minDistance = INF;
		for (int destination = 1; destination <= n; destination++) {
			if (destination == pointJ || destination == pointS)
				continue;
			if (table[pointJ][destination] == INF || table[pointS][destination] == INF)
				continue;
			int combinedDistance = table[pointJ][destination] + table[pointS][destination];
			if (combinedDistance < minDistance) {
				minDistance = combinedDistance;
			}
		}

		int minDistanceOfJihyeon = INF;
		int answerIdx = -1;
		for (int destination = 1; destination <= n; destination++) {
			if (destination == pointJ || destination == pointS)
				continue;
			if (table[pointJ][destination] + table[pointS][destination] != minDistance)
				continue;
			if (table[pointJ][destination] < table[pointS][destination]
				|| table[pointJ][destination] == table[pointS][destination]) {
				if (table[pointJ][destination] < minDistanceOfJihyeon) {
					minDistanceOfJihyeon = table[pointJ][destination];
					answerIdx = destination;
				}
			}
		}

		System.out.println(answerIdx);
	}
}

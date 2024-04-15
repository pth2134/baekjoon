import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] timeToBuild;
	static int[] dp;
	static ArrayList<Queue<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		timeToBuild = new int[n + 1];
		dp = new int[n + 1];
		StringBuilder sb = new StringBuilder();

		list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new LinkedList<>());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			timeToBuild[i] = Integer.parseInt(st.nextToken());
			int pre;
			while ((pre = Integer.parseInt(st.nextToken())) != -1) {
				list.get(i).add(pre);
			}
		}

		for (int i = 1; i <= n; i++) {
			dfs(i);
		}

		for (int i = 1; i <= n; i++) {
			sb.append(dp[i]).append("\n");
		}

		System.out.println(sb);
	}

	public static int dfs(int num) {
		if (dp[num] > 0)
			return dp[num];

		int max = timeToBuild[num];
		Queue<Integer> que = list.get(num);
		while (!que.isEmpty()) {
			max = Integer.max(max, dfs(que.poll()) + timeToBuild[num]);
		}
		return dp[num] = max;
	}

}
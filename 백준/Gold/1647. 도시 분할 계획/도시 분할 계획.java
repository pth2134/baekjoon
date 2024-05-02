import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] visit = new int[n + 1];

		List<Queue<Integer[]>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new LinkedList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(from).add(new Integer[] {to, cost});
			list.get(to).add(new Integer[] {from, cost});
		}

		PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new Integer[] {1, 1});

		while (!pq.isEmpty()) {
			Integer[] poll = pq.poll();
			if (visit[poll[0]] != 0)
				continue;
			visit[poll[0]] = poll[1];
			Queue<Integer[]> que = list.get(poll[0]);
			while (!que.isEmpty()) {
				Integer[] q = que.poll();
				if (visit[q[0]] == 0) {
					pq.add(new Integer[] {q[0], q[1]});
				}
			}
		}

		int sum = 0;
		int max = 0;
		for (int i = 2; i <= n; i++) {
			sum += visit[i];
			max = Math.max(max, visit[i]);
		}

		System.out.println(sum - max);

	}

}
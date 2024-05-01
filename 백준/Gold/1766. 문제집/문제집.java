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
		int[] level = new int[n + 1];

		List<Queue<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			list.add(new LinkedList<>());
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			level[b]++;
		}

		for (int i = 1; i <= n; i++) {
			if (level[i] == 0)
				pq.add(i);
		}

		while (!pq.isEmpty()) {
			int q = pq.poll();
			sb.append(q).append(' ');
			Queue<Integer> que = list.get(q);
			while (!que.isEmpty()) {
				int p = que.poll();
				if (--level[p] == 0) {
					pq.add(p);
				}
			}
		}

		System.out.println(sb);

	}

}
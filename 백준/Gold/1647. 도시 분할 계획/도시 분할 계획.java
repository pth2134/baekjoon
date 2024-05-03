import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] union;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		union = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			union[i] = i;
		}

		PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			pq.add(new Integer[] {from, to, cost});
		}

		int cnt = 0;
		int sum = 0;
		int max = 0;

		while (cnt < n - 1) {
			Integer[] poll = pq.poll();
			int a = unionFind(poll[0]);
			int b = unionFind(poll[1]);

			if (a == b)
				continue;

			if (b > a)
				union[b] = a;
			else
				union[a] = b;
			cnt++;
			sum += poll[2];
			max = Math.max(max, poll[2]);
		}

		System.out.println(sum - max);

	}

	public static int unionFind(int num) {
		if (union[num] != num)
			return unionFind(union[num]);
		return num;
	}

}

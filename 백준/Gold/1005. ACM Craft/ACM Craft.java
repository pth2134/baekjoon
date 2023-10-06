import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] build = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				build[j] = Integer.parseInt(st.nextToken());
			}
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			for (int j = 0; j <= n; j++) {
				list.add(new ArrayList<>());
			}
			int[] base = new int[n+1];
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list.get(from).add(to);
				base[to]++;
			}
			int goal = Integer.parseInt(br.readLine());
			PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
			for (int j = 1; j <= n; j++) {
				if(base[j]==0) {
					if(j==goal) {
						sb.append(build[j]).append("\n");
						pq.clear();
						break;
					}
					pq.add(new Integer[]{j,build[j]});
				}
			}

			while (!pq.isEmpty()){
				Integer[] poll = pq.poll();
				ArrayList<Integer> a = list.get(poll[0]);
				int size = a.size();
				for (int j = 0; j < size; j++) {
					int to = a.get(j);
					if(--base[to]==0) {
						int eta = poll[1]+build[to];
						if(to==goal) {
							sb.append(eta).append("\n");
							pq.clear();
							break;
						}
						pq.add(new Integer[]{to,eta});
					}
				}
			}
		}
		System.out.println(sb);
	}
}
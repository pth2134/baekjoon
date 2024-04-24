import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] belong = new int[n + 1];
		List<Group> list = new ArrayList<>();
		PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			Integer[] input = new Integer[] {
				Integer.parseInt(st.nextToken()), //x1
				Integer.parseInt(st.nextToken()), //x2
				i // n
			};
			pq.add(input);
		}

		Integer[] poll = pq.poll();
		Group lastGroup = new Group(poll[0], poll[1]);
		lastGroup.set.add(poll[2]);
		list.add(lastGroup);
		int groupIdx = 0;
		belong[poll[2]] = groupIdx;

		for (int i = 2; i <= n; i++) {
			poll = pq.poll();
			if (lastGroup.last < poll[0]) {
				lastGroup = new Group(poll[0], poll[1]);
				lastGroup.set.add(poll[2]);
				list.add(lastGroup);
				groupIdx++;
			} else {
				lastGroup.last = Math.max(lastGroup.last, poll[1]);
				lastGroup.set.add(poll[2]);
			}
			belong[poll[2]] = groupIdx;
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (list.get(belong[from]).set.contains(to)) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static class Group {
		int start;
		int last;

		HashSet<Integer> set = new HashSet<>();

		Group(int start, int last) {
			this.start = start;
			this.last = last;
		}
	}

}

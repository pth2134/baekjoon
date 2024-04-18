import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			Long total = 0L;
			PriorityQueue<Integer> abGapA = new PriorityQueue<>((o1, o2) -> o1 - o2);
			PriorityQueue<Integer> abGapB = new PriorityQueue<>((o1, o2) -> o1 - o2);
			int aCnt = 0;
			int bCnt = 0;

			StringTokenizer stA = new StringTokenizer(br.readLine());
			StringTokenizer stB = new StringTokenizer(br.readLine());
			for (int l = 0; l < n; l++) {
				int a = Integer.parseInt(stA.nextToken());
				int b = Integer.parseInt(stB.nextToken());
				if (a > b) {
					total += a;
					abGapA.add(a - b);
					aCnt++;
				} else {
					total += b;
					abGapB.add(b - a);
					bCnt++;
				}
			}

			if (aCnt > 0) {
				int g = aCnt - bCnt;
				while (g > k) {
					total -= abGapA.poll();
					g -= 2;
				}
			} else {
				int g = bCnt - aCnt;
				while (g > k) {
					total -= abGapB.poll();
					g -= 2;
				}
			}

			sb.append(total).append("\n");
		}
		System.out.println(sb);
	}

}
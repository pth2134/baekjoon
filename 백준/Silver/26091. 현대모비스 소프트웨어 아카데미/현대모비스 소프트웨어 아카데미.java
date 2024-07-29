import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] stat = new int[n];
		for (int i = 0; i < n; i++) {
			stat[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(stat);

		int lo = 0;
		int hi = n - 1;
		int team = 0;

		while (lo < hi) {
			if (stat[lo] + stat[hi] < m) {
				lo++;
				continue;
			}
			team++;
			lo++;
			hi--;
		}

		System.out.println(team);
	}

}
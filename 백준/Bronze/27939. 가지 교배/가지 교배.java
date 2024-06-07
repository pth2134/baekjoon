import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char result = 'P';

		boolean[] gen = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			gen[i] = br.read() == 'W';
			br.read();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			boolean allW = true;
			for (int j = 0; j < k; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (!gen[num]) {
					allW = false;
					break;
				}
			}
			if (allW) {
				result = 'W';
				break;
			}
		}

		System.out.println(result);

	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), "-");
			int y = Integer.parseInt(st.nextToken());
			if (year > y)
				continue;
			else if (year < y) {
				cnt++;
				continue;
			}
			int m = Integer.parseInt(st.nextToken());
			if (month > m)
				continue;
			else if (month < m) {
				cnt++;
				continue;
			}
			int d = Integer.parseInt(st.nextToken());
			if (day > d)
				continue;
			cnt++;
		}

		System.out.println(cnt);
	}

}

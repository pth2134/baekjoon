import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = 0;
			int y = 0;
			for (int j = 0; j < 2; j++) {
				int input = Integer.parseInt(st.nextToken());
				int a = 1;
				int k = 0;
				while (input > a) {
					a += ++k;
				}
				if (input == a)
					k++;
				else
					a -= k;

				int gap = input - a;
				x += 1 + gap;
				y += k - gap;
			}

			int k = x + y - 1;
			int a = k * (k - 1) / 2 + 1;
			int gap = k - y;

			sb.append(a + gap).append('\n');

		}

		System.out.println(sb);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		br.readLine();

		for (int i = 0; i < m; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input > 0) {
				if (k > input)
					continue;

				k = input - k + 1;
			} else {
				if (k < n + input + 1)
					continue;

				k = -k + n + input + 1 + n;
			}

		}

		System.out.println(k);
	}

}
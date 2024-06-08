import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			int result = 3;
			for (int j = 1; j < str.length() - 1; j++) {
				if (str.charAt(j) != 'O')
					continue;

				if (str.charAt(j - 1) == 'M') {
					if (str.charAt(j + 1) == 'O') {
						result = 0;
						break;
					} else {
						result = Math.min(result, 1);
					}
				} else {
					if (str.charAt(j + 1) == 'O') {
						result = Math.min(result, 1);
					} else {
						result = Math.min(result, 2);
					}
				}
			}

			if (result < 3)
				sb.append(str.length() - 3 + result);
			else
				sb.append(-1);
			sb.append('\n');
		}

		System.out.println(sb);
	}

}

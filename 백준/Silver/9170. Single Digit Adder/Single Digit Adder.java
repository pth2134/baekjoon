import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while ((input = br.readLine()) !=null && !input.isEmpty()) {
			sb.append(calc(0)[0]).append('\n');
		}

		System.out.println(sb);
	}

	static int[] calc(int idx) {
		boolean isMinus = false;
		int sum = 0;

		for (; idx < input.length(); idx++) {
			char c = input.charAt(idx);

			if (c == ')') {
				return new int[] {sum, idx};
			}

			if (c == '(') {
				int[] p = calc(idx + 1);
				sum += isMinus ? -p[0] : p[0];
				idx = p[1];
				isMinus = false;
				continue;
			}

			if (c == '-') {
				isMinus = true;
				continue;
			}

			if (c > 47 && c < 58) {
				int number = c - 48;
				while (++idx < input.length()) {
					c = input.charAt(idx);
					if (c > 47 && c < 58) {
						number *= 10;
						number += c - 48;
					} else {
						idx--;
						break;
					}
				}

				sum += isMinus ? -number : number;
				isMinus = false;
				continue;
			}

		}

		return new int[] {sum, 0};
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int p = Integer.parseInt(br.readLine());
		for (int i = 1; i <= p; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();

			Stack<Integer> stack = new Stack<>();
			int cnt = 0;
			for (int j = 0; j < 12; j++) {
				int input = Integer.parseInt(st.nextToken());

				if (stack.isEmpty()) {
					stack.push(input);
					continue;
				}

				int peek = stack.peek();

				if (input > peek) {
					stack.push(input);
					continue;
				}

				while (input < peek) {
					stack.pop();
					if (stack.isEmpty())
						break;
					peek = stack.peek();
					cnt++;
				}

				if (input > peek)
					stack.push(input);
			}

			sb.append(i).append(' ').append(cnt).append('\n');
		}
		System.out.println(sb);
	}

}

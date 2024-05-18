import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args)
		throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			if (input.length() >= 6 && input.length() <= 9) {
				sb.append("yes").append('\n');
			} else {
				sb.append("no").append('\n');
			}
		}
		System.out.println(sb);
	}
}

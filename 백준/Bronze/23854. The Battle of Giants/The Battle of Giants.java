import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		int r = a % 3;
		if (r != b % 3) {
			System.out.println(-1);
			return;
		}

		a -= r;
		b -= r;
		sb.append(a / 3).append(' ')
			.append(r).append(' ')
			.append(b / 3);

		System.out.println(sb);
	}
}
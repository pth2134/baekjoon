import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		boolean isJava = false;
		boolean isC = false;

		{
			char start = str.charAt(0);
			char last = str.charAt(str.length() - 1);
			if (start <= 90 || start == 95 || last == 95) {
				System.out.println("Error!");
				return;
			}
		}

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c >= 97) {
				sb.append(c);
				continue;
			}

			if (c <= 90) {
				isJava = true;
				c += 32;
				sb.append('_').append(c);
				continue;
			}

			c = str.charAt(++i);
			if (c == 95 || c <= 90) {
				System.out.println("Error!");
				return;
			}
			isC = true;
			c -= 32;
			sb.append(c);
		}

		if (isJava && isC) {
			System.out.println("Error!");
			return;
		}

		System.out.println(sb);
	}

}

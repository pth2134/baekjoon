import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String L = st.nextToken();
		String R = st.nextToken();

		int cnt = 0;

		if (L.length() == R.length()) {
			boolean remain = false;
			for (int i = 0; i < R.length(); i++) {
				int l = L.charAt(i) - 48;
				int r = R.charAt(i) - 48;

				if (remain) {
					continue;
				} else {
					if (l == 8 && r == 8)
						cnt++;
				}

				if (l < r)
					remain = true;
			}
		}

		System.out.println(cnt);

	}

}
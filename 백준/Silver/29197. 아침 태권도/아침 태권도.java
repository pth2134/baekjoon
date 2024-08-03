import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Map<Integer, Set<Integer>> map = new HashMap<>();

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int gcd = getGcd(x, y);

			x /= gcd;
			y /= gcd;

			if (!map.containsKey(x))
				map.put(x, new HashSet<>());

			Set<Integer> set = map.get(x);

			if (!set.contains(y)) {
				cnt++;
				set.add(y);
			}
		}

		System.out.println(cnt);
	}

	public static int getGcd(int a, int b) {
		if (b == 0)
			return a;
		return getGcd(b, a % b);
	}

}

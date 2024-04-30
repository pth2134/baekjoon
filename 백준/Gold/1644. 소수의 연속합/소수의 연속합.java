import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] isComposite = new boolean[n + 1];

		int cnt = 0;
		for (int i = 2; i <= n; i++) {
			if (!isComposite[i]) {
				cnt++;
				for (int j = 2 * i; j <= n; j += i) {
					isComposite[j] = true;
				}
			}
		}

		int[] prime = new int[cnt];
		int idx = 0;
		for (int i = 2; i <= n; i++) {
			if (!isComposite[i]) {
				prime[idx++] = i;
			}
		}

		int result = 0;

		for (int i = 0; i < cnt; i++) {
			int sum = 0;
			for (int j = i; j < cnt; j++) {
				sum += prime[j];
				if (sum == n)
					result++;
				if (sum > n)
					break;
			}
		}

		System.out.println(result);
	}

}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String string;
	static int[] dp;
	static boolean[][] palindrome;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		string = br.readLine();
		int len = string.length();
		dp = new int[len + 1];
		palindrome = new boolean[len + 1][len + 1];

		for (int i = 0; i < len; i++) {
			isPalindrome(i, len);
		}

		for (int i = 1; i <= len; i++) {
			dp[i] = i;
		}

		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= i; j++) {
				if (palindrome[j][i]) {
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
				}
			}
		}

		System.out.println(dp[len]);
	}

	public static void isPalindrome(int idx, int len) {
		int range = Math.min(idx, len - idx - 1);
		int cnt = 0;
		int newIdx = idx + 1;
		palindrome[newIdx][newIdx] = true;
		for (int i = 1; i <= range; i++) {
			if (string.charAt(idx - i) == string.charAt(idx + i)) {
				cnt++;
				palindrome[newIdx - cnt][newIdx + cnt] = true;
			} else
				break;
		}
		cnt = 0;
		range = Math.min(idx, len - idx - 2);
		for (int i = 0; i <= range; i++) {
			if (string.charAt(idx - i) == string.charAt(idx + i + 1)) {
				cnt++;
				palindrome[newIdx - cnt + 1][newIdx + cnt] = true;
			} else
				break;
		}
	}

}

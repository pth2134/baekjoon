import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[][] dp;
	static int l;
	static long i;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		i = Long.parseLong(st.nextToken());
		dp = new long[n + 1][l + 1]; //dp[자리수][1개수]
		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 2;

		int length = 0;

		for (int j = 2; j <= l; j++) {
			dp[j][0] = 1;
			for (int k = 1; k <= j; k++) {
				dp[j][k] = dp[j - 1][Math.min(j - 1, k)] + dp[j - 1][k - 1];
			}
		}
		for (int j = l + 1; j <= n; j++) {
			dp[j][0] = 1;
			for (int k = 1; k <= l; k++) {
				dp[j][k] = dp[j - 1][k] + dp[j - 1][k - 1]; //맨앞자리가 0인 경우, 1인 경우
			}
		}

		for (int j = l; j <= n; j++) {
			if (dp[j][l] >= i) {
				length = j;
				break;
			}

		}

		for (int j = 0; j < n - length; j++) {
			sb.append(0);
		}

		findI(length, l);
		System.out.println(sb);
	}

	public static void findI(int length, int oneCnt) {
		if (length == 0)
			return;
		long min = dp[length - 1][Math.min(length - 1, oneCnt)]; //맨 앞자리가 0인 경우의 개수
		if (min >= i) {//0인 경우에도 부족하다면 자리수를 줄여서 확인
			sb.append(0);
			findI(length - 1, oneCnt);
		} else {//0인 경우를 넘어간다면 앞자리 1 확정
			sb.append(1);
			i -= min;
			findI(length - 1, oneCnt - 1);
		}
	}

}
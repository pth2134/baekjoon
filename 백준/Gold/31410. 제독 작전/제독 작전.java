import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		long[][] poison = new long[n][2]; // 0 위치 1 양
		long[][] saving = new long[n][2]; // saving[0][0] = 0을 제외하고 제독할 때 아낄 수 있는 양 0왼쪽부터 1 오른쪽부터

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			poison[i][0] = Long.parseLong(st.nextToken());
			poison[i][1] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(poison, (o1, o2) -> Long.compare(o1[0], o2[0]));

		long leftDefaultSum = poison[0][1];
		long rightDefaultSum = poison[n - 1][1];
		for (int i = 1; i < n; i++) {
			leftDefaultSum += poison[i][1] + i * (poison[i][0] - poison[i - 1][0]);
			rightDefaultSum += poison[n - 1 - i][1] + i * (poison[n - i][0] - poison[n - 1 - i][0]);
		}

		for (int i = 1; i < n - 1; i++) {
			saving[i][0] = poison[n - 1][0] - poison[i][0] + poison[i][1];
			saving[i][1] = poison[i][0] - poison[0][0] + poison[i][1];
		}
		saving[0][0] = poison[n - 1][0] - poison[0][0] + poison[0][1];
		saving[0][1] = (n - 1) * (poison[1][0] - poison[0][0]) + poison[0][1];
		saving[n - 1][0] = (n - 1) * (poison[n - 1][0] - poison[n - 2][0]) + poison[n - 1][1];
		saving[n - 1][1] = poison[n - 1][0] - poison[0][0] + poison[n - 1][1];

		long min = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, leftDefaultSum - saving[i][0]);
			min = Math.min(min, rightDefaultSum - saving[i][1]);
		}

		System.out.println(min);
	}
}

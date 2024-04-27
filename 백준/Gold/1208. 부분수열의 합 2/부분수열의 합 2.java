import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> rightSum = new ArrayList<>();
		List<Integer> leftSum = new ArrayList<>();

		bulb(0, n / 2, 0, leftSum);
		bulb(n / 2, n, 0, rightSum);

		Collections.sort(leftSum);
		Collections.sort(rightSum);

		long cnt = getCnt(rightSum, leftSum, s);

		System.out.println(s == 0 ? cnt - 1 : cnt);

	}

	private static long getCnt(List<Integer> rightSum, List<Integer> leftSum, int s) {
		int left = 0;
		int right = rightSum.size() - 1;
		long cnt = 0;

		while (left < leftSum.size() && right >= 0) {
			int sum = leftSum.get(left) + rightSum.get(right);

			if (sum == s) {
				long leftValue = leftSum.get(left);
				long leftSameCnt = 0;
				while (left < leftSum.size() && leftSum.get(left) == leftValue) {
					left++;
					leftSameCnt++;
				}

				int rightValue = rightSum.get(right);
				int rightSameCnt = 0;
				while (right >= 0 && rightSum.get(right) == rightValue) {
					right--;
					rightSameCnt++;
				}

				cnt += leftSameCnt * rightSameCnt;
			} else if (sum < s) {
				left++;
			} else {
				right--;
			}

		}
		return cnt;
	}

	public static void bulb(int idx, int last, int sum, List<Integer> list) {
		if (idx == last) {
			list.add(sum);
			return;
		}

		bulb(idx + 1, last, sum + arr[idx], list);
		bulb(idx + 1, last, sum, list);
	}
}
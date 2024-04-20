import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] water = new long[n];
		for (int i = 0; i < n; i++) {
			water[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(water);
		
		int[] result = new int[3];
		long min = Long.MAX_VALUE;
		int start, mid, end;
		for (int i = 0; i < n - 2; i++) {
			start = i;
			mid = i + 1;
			end = n - 1;
			while (mid < end) {
				long sum = water[start] + water[mid] + water[end];
				if (min > Math.abs(sum)) {
					min = Math.abs(sum);
					result[0] = start;
					result[1] = mid;
					result[2] = end;
				}
				if (sum == 0) {
					break;
				} else if (sum > 0) {
					end--;
				} else {
					mid++;
				}
			}
		}
		sb.append(water[result[0]]).append(' ').append(water[result[1]]).append(' ').append(water[result[2]]);
		System.out.println(sb);

	}

}
import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] rope = new int[100001];
		for (int i = 1; i <= n; i++) {
			rope[Integer.parseInt(br.readLine())]++;
		}
		int sum = 0;
		int max = 0;
		int cnt = 0;
		for (int i = 100000; i > 0; i--) {
			cnt += rope[i];
			sum = i*cnt;
			max = max>sum? max:sum;
		}
		System.out.println(max);
	}
 }
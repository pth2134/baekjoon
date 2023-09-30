import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] b = new int[1001];
		int[] a = new int[n];
		int[] p = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(st.nextToken());
			a[i] = input;
			b[input]++;
		}
		b[0]--;
		for (int i = 1; i <= 1000; i++) {
			b[i] += b[i-1];
		}
		for (int i = n-1; i >= 0; i--) {
			p[i] = b[a[i]]--;
		}
		for (int i = 0; i < n; i++) {
			sb.append(p[i]).append(" ");
		}
		System.out.println(sb);
	}
}
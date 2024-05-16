import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int[] A = new int[3];
		int[] C = new int[3];

		for (int i = 0; i < 3; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}

		sb.append(C[0] - A[2]).append(" ")
			.append(C[1] / A[1]).append(" ")
			.append(C[2] - A[0]);

		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();

		int[] alp = new int[26];
		for (int i = 0; i < str.length(); i++) {
			alp[str.charAt(i) - 97]++;
		}

		for (int i = 0; i < 26; i++) {
			sb.append(alp[i]).append(' ');
		}

		System.out.println(sb);
	}

}
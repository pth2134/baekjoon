import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Set<Character> set = new HashSet<>(List.of('A', 'B', 'C', 'D', 'E', 'F'));

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			boolean[] rule = new boolean[5];

			if (set.contains(str.charAt(0)))
				rule[0] = true;
			if (str.charAt(0) == 'A')
				rule[1] = true;
			else if (str.charAt(1) == 'A') {
				rule[1] = true;
			}
			int j = 1;
			for (; j < str.length(); j++) {
				if (str.charAt(j) != 'A')
					break;
			}
			if (j < str.length() && str.charAt(j) == 'F')
				rule[2] = true;
			for (; j < str.length(); j++) {
				if (str.charAt(j) != 'F')
					break;
			}
			if (j < str.length() && str.charAt(j) == 'C')
				rule[3] = true;
			for (; j < str.length(); j++) {
				if (str.charAt(j) != 'C')
					break;
			}
			if (j == str.length() - 1) {
				if (set.contains(str.charAt(j)))
					rule[4] = true;
			} else if (j == str.length())
				rule[4] = true;

			if (rule[0] && rule[1] && rule[2] && rule[3] && rule[4])
				sb.append("Infected!\n");
			else
				sb.append("Good\n");
		}
		System.out.println(sb);
	}

}

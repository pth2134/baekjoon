import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> lyricsSet = new HashSet<>();

		// 문자열 추가
		lyricsSet.add("Never gonna give you up");
		lyricsSet.add("Never gonna let you down");
		lyricsSet.add("Never gonna run around and desert you");
		lyricsSet.add("Never gonna make you cry");
		lyricsSet.add("Never gonna say goodbye");
		lyricsSet.add("Never gonna tell a lie and hurt you");
		lyricsSet.add("Never gonna stop");

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			if (!lyricsSet.contains(input)) {
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}

}
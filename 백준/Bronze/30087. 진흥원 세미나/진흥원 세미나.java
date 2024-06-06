import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Map<String, String> courses = new HashMap<>();
		courses.put("Algorithm", "204");
		courses.put("DataAnalysis", "207");
		courses.put("ArtificialIntelligence", "302");
		courses.put("CyberSecurity", "B101");
		courses.put("Network", "303");
		courses.put("Startup", "501");
		courses.put("TestStrategy", "105");
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			sb.append(courses.get(br.readLine())).append('\n');
		}

		System.out.println(sb);
	}
}
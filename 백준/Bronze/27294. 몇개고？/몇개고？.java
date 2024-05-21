import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)
		throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int time = Integer.parseInt(st.nextToken());
		boolean lunch = time >= 12 && time <= 16;
		boolean drink = st.nextToken().equals("1");

		if (lunch && !drink)
			System.out.println(320);
		else
			System.out.println(280);

	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "WelcomeToSMUPC";
		int n = Integer.parseInt(br.readLine()) % 14;
		if (n == 0)
			n = 14;

		System.out.println(str.charAt(n - 1));
	}

}
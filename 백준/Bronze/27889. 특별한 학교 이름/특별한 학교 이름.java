import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args)
		throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		switch (str) {
			case "NLCS":
				str = "North London Collegiate School";
				break;
			case "BHA":
				str = "Branksome Hall Asia";
				break;
			case "KIS":
				str = "Korea International School";
				break;
			case "SJA":
				str = "St. Johnsbury Academy";
				break;
			default:
				str = str;
				break;
		}
		System.out.println(str);
	}
}
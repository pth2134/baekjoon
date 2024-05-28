import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String out = "";

		switch (str) {
			case "SONGDO":
				out = "HIGHSCHOOL";
				break;
			case "CODE":
				out = "MASTER";
				break;
			case "2023":
				out = "0611";
				break;
			case "ALGORITHM":
				out = "CONTEST";
				break;
		}

		System.out.println(out);
	}
}
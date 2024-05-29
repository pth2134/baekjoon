import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c = (char) br.read();
		String out = "";

		switch (c) {
			case 'M':
				out = "MatKor";
				break;
			case 'W':
				out = "WiCys";
				break;
			case 'C':
				out = "CyKor";
				break;
			case 'A':
				out = "AlKor";
				break;
			case '$':
				out = "$clear";
				break;
		}

		System.out.println(out);
	}
}
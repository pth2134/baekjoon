import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String binary = Integer.toBinaryString(n);

		int cnt = 0;
		int index = binary.length() - 1;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1')
				cnt++;
			if (cnt == k) {
				index = i;
				break;
			}
		}

		if (index == binary.length() - 1) {
			System.out.println(0);
		} else {
			binary = binary.substring(index + 1);
			int base = 1 << binary.length();
			int binaryToDecimal = Integer.parseInt(binary, 2);
			int result = base - binaryToDecimal;
			System.out.println(base == result ? 0 : result);
		}

	}

}
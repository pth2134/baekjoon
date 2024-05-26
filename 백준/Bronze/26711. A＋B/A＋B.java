import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
	public static void main(String[] args)
		throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigDecimal a = new BigDecimal(br.readLine());
		BigDecimal b = new BigDecimal(br.readLine());
		
		System.out.println(
			a.add(b)
		);
	}
}
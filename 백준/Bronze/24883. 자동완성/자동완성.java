import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
	public static void main(String[] args)
		throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (List.of('N', 'n').contains((char)br.read()))
			System.out.println("Naver D2");
		else
			System.out.println("Naver Whale");
	}
}

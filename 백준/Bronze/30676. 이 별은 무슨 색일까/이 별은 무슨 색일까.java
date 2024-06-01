import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] length = {425, 450, 495, 570, 590, 620, 780};
		String[] color = {"Violet", "Indigo", "Blue", "Green", "Yellow", "Orange", "Red", "Red"};

		int i = 0;
		for (; i < length.length; i++) {
			if (n < length[i])
				break;
		}

		System.out.println(color[i]);

	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Integer.parseInt(br.readLine());
		long stand = 1L;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(i);
		}

		for (long i = 1L; i <= n - 1; i++) {
			long cnt = i * i * i - 1;
			int size = list.size() - 1;

			long next = stand + cnt;
			next %= size;
			if (next == 0) {
				next = size;
				stand = 1;
			} else {
				stand = next;
			}
			list.remove((int)next);
		}

		System.out.println(list.get(1));

	}

}
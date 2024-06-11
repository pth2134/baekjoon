import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		long lcm = 1;
		long answer = 1;

		for (int i = 0; i < str.length(); i++) {
			int a = str.charAt(i) - 48;
			if (a == 0)
				continue;
			if (lcm % a == 0)
				continue;
			lcm = getLCM(lcm, a);
		}

		long n = Long.parseLong(str);

		if (n % lcm == 0) {
			System.out.println(n);
			return;
		}

		Queue<Long> que = new LinkedList<>();
		que.add(n);

		while (true) {
			long n2 = que.poll() * 10;
			if (n2 % lcm == 0) {
				answer = n2;
				break;
			}
			que.add(n2);

			for (int i = 1; i < 10; i++) {
				n2++;
				if (n2 % lcm == 0) {
					System.out.println(n2);
					return;
				}
				que.add(n2);
			}
		}

		System.out.println(answer);
	}

	static long getLCM(long a, long b) {
		return a * b / getGCD(a, b);
	}

	static long getGCD(long a, long b) {
		if (a % b == 0)
			return b;
		return getGCD(b, a % b);
	}
}
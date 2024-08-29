import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();

		int[] papers = new int[7];
		int answer = 0;

		for (int i = 1; i <= 6; i++) {
			papers[i] = reader.nextInt();
		}

		answer += papers[6];

		while (papers[5] > 0 && papers[1] > 0) {
			answer++;
			papers[5]--;
			papers[1] = Math.max(papers[1] - 11, 0);
		}
		answer += papers[5];

		while (papers[4] > 0) {
			answer++;
			papers[4]--;
			if (papers[2] >= 5)
				papers[2] -= 5;
			else {
				int remain = 20 - papers[2] * 4;
				papers[2] = 0;
				papers[1] = Math.max(papers[1] - remain, 0);
			}
		}

		answer += papers[3] / 4;
		papers[3] %= 4;

		if (papers[3] > 0) {
			if (papers[3] == 3) {
				if (papers[2] > 0) {
					papers[2]--;
					papers[1] = Math.max(papers[1] - 5, 0);
				} else {
					papers[1] = Math.max(papers[1] - 9, 0);
				}
			} else if (papers[3] == 2) {
				if (papers[2] > 3) {
					papers[2] -= 3;
					papers[1] = Math.max(papers[1] - 6, 0);
				} else {
					int remain = 18 - papers[2] * 4;
					papers[2] = 0;
					papers[1] = Math.max(papers[1] - remain, 0);
				}
			} else {
				if (papers[2] > 5) {
					papers[2] -= 5;
					papers[1] = Math.max(papers[1] - 7, 0);
				} else {
					int remain = 27 - papers[2] * 4;
					papers[2] = 0;
					papers[1] = Math.max(papers[1] - remain, 0);
				}
			}

			answer++;
		}

		answer += papers[2] / 9;
		papers[2] %= 9;

		if (papers[2] > 0) {
			int remain = 36 - papers[2] * 4;
			papers[1] = Math.max(papers[1] - remain, 0);
			answer++;
		}

		answer += papers[1] / 36;
		if (papers[1] % 36 > 0)
			answer++;

		System.out.println(answer);

	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

		int nextInt() throws IOException {
			int n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			boolean neg = c == '-';
			if (neg)
				c = read();
			do
				n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
			return neg ? -n : n;
		}

		boolean isNumber(byte c) {
			return 47 < c && c < 58;
		}

		byte read() throws IOException {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}

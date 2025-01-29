import java.io.IOException;

public class Main {
	static final long MOD = 1_000_000_007L;

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();

		long a = reader.nextLong();
		long b = reader.nextLong();

		if (a == 1) {
			System.out.println((a * b) % MOD);
			return;
		}

		long son = (modPow(a, b, MOD) - 1) % MOD;
		long mom = a - 1;

		System.out.println(solve(son, mom));
	}

	static long modPow(long base, long exp, long mod) {
		long result = 1;
		while (exp > 0) {
			if ((exp & 1) == 1) { // 홀수 지수일 때
				result = (result * base) % mod;
			}
			base = (base * base) % mod;
			exp >>= 1; // 지수를 2로 나눔
		}
		return result;
	}

	static long modInverse(long b, long mod) {
		return modPow(b, mod - 2, mod);
	}

	static long solve(long a, long b) {
		long invB = modInverse(b, MOD); // bMod의 모듈러 역원 계산
		return (a * invB) % MOD; // 최종 결과
	}

	static class Reader {
		final int SIZE = 1 << 15;
		byte[] buffer = new byte[SIZE];
		int index, size;

		byte read() throws IOException {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}

		boolean isNumber(byte c) {
			return 47 < c && c < 58;
		}

		long nextLong() throws IOException {
			long n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			boolean neg = c == '-' ? true : false;
			if (neg)
				c = read();
			do
				n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
			return neg ? -n : n;
		}
	}
}

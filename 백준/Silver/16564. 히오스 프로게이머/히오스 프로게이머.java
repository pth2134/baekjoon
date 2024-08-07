import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();
		long k = reader.nextLong();
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.add(reader.nextLong());
		}

		long T = pq.poll(); //최저레벨
		long cnt = 1; //최저레벨 캐릭터수
        //최저레벨 캐릭터를 다음으로 낮은 캐릭터의 레벨에 맞추고, 최저레벨 캐릭터가 1명 늘어남
		while (!pq.isEmpty()) {
			long level = pq.poll();

			if (level == T) {
				cnt++;
				continue;
			}

			long gap = level - T;
			long total_gap = gap * cnt;
			if (k >= total_gap) {
				T = level;
				k -= total_gap;
				cnt++;
			} else {
				T += k / cnt;
                k=0;
				break;
			}

		}
        
        if (k > 0) {
            //k가 남았다면 모두 같은 레벨이기 때문에 동일하게 나눠줘야함
			T += k / n;
		}

		System.out.println(T);

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

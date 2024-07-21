import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int n = reader.nextInt();

		Map<String, int[]> timetable = new HashMap<>();
		Set<String> dup = new HashSet<>();

		for (int i = 0; i < n; i++) {
			String name = reader.nextString();
			String place = reader.nextString();
			int start = reader.nextInt();
			int end = reader.nextInt();

			if (dup.contains(name))
				continue;

			dup.add(name);
			timetable.putIfAbsent(place, new int[50001]);
			int[] table = timetable.get(place);
			for (int j = start; j <= end; j++) {
				table[j]++;
			}
		}

		List<String> sortedKeys = new ArrayList<>(timetable.keySet());
		Collections.sort(sortedKeys);

		String max_place = "";
		int max = 0;
		int start = 0;
		int end = 0;
		boolean seq = false;

		for (String place : sortedKeys) {
			int[] table = timetable.get(place);
			int max2 = max;
			int start2 = 0;
			for (int i = 0; i <= 50000; i++) {
				if (table[i] > max2) {
					max2 = table[i];
					start2 = i;
					seq = true;
				} else if (table[i] == max2 && seq) {
					max_place = place;
					max = max2;
					start = start2;
					end = i;
				} else {
					max2 = max;
					start2 = start;
					seq = false;
				}
			}
			seq = false;
		}

		System.out.println(max_place + " " + start + " " + end);
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

		String nextString() throws IOException {
			StringBuilder sb = new StringBuilder();
			byte c;
			while ((c = read()) <= 32)
				;
			do {
				sb.append((char)c);
			} while ((c = read()) > 32);
			return sb.toString();
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

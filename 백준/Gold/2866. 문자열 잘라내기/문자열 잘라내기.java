import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static char[][] strings;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		strings = new char[c][r];

		for (int i = r - 1; i >= 0; i--) {
			for (int j = 0; j < c; j++) {
				strings[j][i] = (char)br.read();
			}
			br.read();
		}

		Arrays.sort(strings, (o1, o2) -> o1[0] - o2[0]);

		int max = 0;
		HashSet<Integer> set = new HashSet<>();
		set.add(0);

		for (int i = 0; i < c - 1; i++) {
			if (strings[i][0] != strings[i + 1][0]) {
				if (set.size() > 1) {
					max = Integer.max(max, redundantCount(set, 1));
				}
				set = new HashSet<>();
			}
			set.add(i + 1);
		}

		if (set.size() > 1)
			max = Integer.max(max, redundantCount(set, 0));

		System.out.println(r - max - 1);
	}

	public static int redundantCount(HashSet<Integer> set, int depth) {
		HashMap<Character, HashSet<Integer>> map = new HashMap<>();
		for (int i : set) {
			char c = strings[i][depth];
			if (map.containsKey(c)) {
				map.get(c).add(i);
			} else
				map.put(strings[i][depth], new HashSet<>() {{
					add(i);
				}});
		}
		int max = depth;
		Set<Character> newSet = map.keySet();
		for (Character i : newSet) {
			if (map.get(i).size() > 1)
				max = Integer.max(max, redundantCount(map.get(i), depth + 1));
		}
		return max;
	}

}

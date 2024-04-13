import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static String[] depthString = new String[15];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Cave entrance = new Cave();
		initializeDepthString();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			Cave current = entrance;
			for (int j = 0; j < k; j++) {
				String input = st.nextToken();
				if (current.map.containsKey(input)) {
					current = current.map.get(input);
				} else {
					Cave newCave = new Cave();
					current.map.put(input, newCave);
					current.pq.add(input);
					current = newCave;
				}
			}
		}

		buildString(entrance, 0);
		System.out.println(sb);
	}

	public static void initializeDepthString() {
		//일일이 --를 만들지 않도록 하기 위해 String배열을 만듬
		StringBuilder depthSb = new StringBuilder();
		depthString[0] = "";
		for (int i = 1; i < 15; i++) {
			depthSb.append("--");
			depthString[i] = depthSb.toString();
		}
	}

	static class Cave {
		PriorityQueue<String> pq = new PriorityQueue<>();
		Map<String, Cave> map = new HashMap<>();
	}

	public static void buildString(Cave cave, int depth) {
		PriorityQueue<String> pq = cave.pq;
		while (!pq.isEmpty()) {
			String value = pq.poll();
			sb.append(depthString[depth]).append(value).append("\n");
			buildString(cave.map.get(value), depth + 1);
		}
	}

}
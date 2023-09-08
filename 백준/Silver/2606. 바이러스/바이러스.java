import java.io.*;
import java.util.*;

class Main{
	static int n;
	static int m;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int cnt = -1;

	static void dfs(int r){
		visited[r] = true;
		cnt++;
		int size = graph.get(r).size();
		for(int i =0; i<size; i++){
			int next = graph.get(r).get(i);
			if(!visited[next]) dfs(next);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];

		for (int i = 0; i <= n ; i++) {
			graph.add(new ArrayList<>());
		}

		for(int i =0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph.get(from).add(to);
			graph.get(to).add(from);
		}

		dfs(1);

		System.out.println(cnt);
	}
 }
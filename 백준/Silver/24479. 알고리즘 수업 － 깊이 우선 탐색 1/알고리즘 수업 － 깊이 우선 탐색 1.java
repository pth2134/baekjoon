import java.io.*;
import java.util.*;

class Main{
	static int n;
	static int m;
	static ArrayList<PriorityQueue<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int[] route;
	static int cnt = 1;

	static void dfs(int r){
		visited[r] = true;
		route[r] = cnt++;
		int size = graph.get(r).size();
		for(int i =1; i<=size; i++){
			int next = graph.get(r).poll();
			if(!visited[next]){
				dfs(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		route = new int[n+1];
		visited = new boolean[n+1];

		for (int i = 0; i <= n ; i++) {
			graph.add(new PriorityQueue<>());
		}

		for(int i =0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		dfs(r);
		for(int i =1; i<=n; i++){
			sb.append(route[i]).append("\n");
		}
		System.out.println(sb);
	}
 }
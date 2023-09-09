import java.io.*;
import java.util.*;

public class Main{
	static int n;
	static int m;
	static boolean[] dVisited;
	static boolean[] bVisited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> que = new LinkedList<>();
	static void dfs(int r) {
		dVisited[r] = true;
		sb.append(r).append(" ");
		for(int i  : list.get(r)) {
			if(!dVisited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int r) {
		bVisited[r] = true;
		sb.append(r).append(" ");
		for(int i : list.get(r)) {
			if(!bVisited[i]) {
				que.add(i);
				bVisited[i] = true;
			}
		}
		while(!que.isEmpty()) {
			int poll = que.poll();
			bfs(poll);
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		dVisited = new boolean[n+1];
		bVisited = new boolean[n+1];
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(list.get(i));
		}
		
		dfs(r);
		sb.append("\n");
		bfs(r);

		System.out.println(sb);
	}

}

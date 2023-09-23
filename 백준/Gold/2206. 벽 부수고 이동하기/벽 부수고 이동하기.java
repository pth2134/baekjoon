import java.io.*;
import java.util.*;
class Main{
	static int n;
	static int m;
	static int[][] graph;
	static int[][][] visited;
	static Queue<Integer[]> que = new LinkedList<>();
	static void bfs(int y, int x,int crush, int cnt){
		if(x>0) {
			if(visited[y][x-1][crush]==0){
				if(graph[y][x-1]==0) {
					Integer[] next = {y,x-1,crush,cnt+1};
					que.add(next);
					visited[y][x-1][crush]=cnt+1;
				}
				else if(crush==0) {
					if(visited[y][x-1][1]==0) {
						Integer[] next = {y,x-1,1,cnt+1};
						que.add(next);
						visited[y][x-1][1]=cnt+1;
					}
				}
			}
		}
		if(x<m-1) {
			if(visited[y][x+1][crush]==0){
				if(graph[y][x+1]==0) {
					Integer[] next = {y,x+1,crush,cnt+1};
					que.add(next);
					visited[y][x+1][crush]=cnt+1;
				}
				else if(crush==0) {
					if(visited[y][x+1][1]==0) {
						Integer[] next = {y,x+1,1,cnt+1};
						que.add(next);
						visited[y][x+1][1]=cnt+1;
					}
				}
			}
		}
		if(y>0) {
			if(visited[y-1][x][crush]==0){
				if(graph[y-1][x]==0) {
					Integer[] next = {y-1,x,crush,cnt+1};
					que.add(next);
					visited[y-1][x][crush]=cnt+1;
				}
				else if(crush==0) {
					if(visited[y-1][x][1]==0) {
						Integer[] next = {y-1,x,1,cnt+1};
						que.add(next);
						visited[y-1][x][1]=cnt+1;
					}
				}
			}
		}
		if(y<n-1) {
			if(visited[y+1][x][crush]==0){
				if(graph[y+1][x]==0) {
					Integer[] next = {y+1,x,crush,cnt+1};
					que.add(next);
					visited[y+1][x][crush]=cnt+1;
				}
				else if(crush==0) {
					if(visited[y+1][x][1]==0) {
						Integer[] next = {y+1,x,1,cnt+1};
						que.add(next);
						visited[y+1][x][1]=cnt+1;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		visited = new int[n][m][2];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i][j]=str.charAt(j)-48;
			}
		}
		visited[0][0][0]=1;
		bfs(0,0,0, 1);
		while(!que.isEmpty()){
			Integer[] poll = que.poll();
			bfs(poll[0],poll[1],poll[2],poll[3]);
		}
		int a = visited[n-1][m-1][0];
		int b = visited[n-1][m-1][1];
		int min = 0;
		if(a!=0&&b!=0) min = Math.min(a,b);
		else if(a==0&&b==0) min = -1;
		else min = Math.max(a,b);

		System.out.println(min);
	}
}
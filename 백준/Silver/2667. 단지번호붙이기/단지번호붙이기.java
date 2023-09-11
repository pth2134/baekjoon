import java.io.*;
import java.util.*;

class Main{
	static int n;
	static int[][] board;
	static boolean[][] visited;
	static int block = 0;
	static int cnt = 0;

	static void dfs(int r, int c){
		visited[r][c] = true;
		if(board[r][c]==0) return;
		cnt++;
		if(r>0){
			if(!visited[r-1][c]){
				dfs(r-1,c);
			}
		}
		if(r<n-1){
			if(!visited[r+1][c]){
				dfs(r+1,c);
			}
		}
		if(c>0){
			if(!visited[r][c-1]){
				dfs(r,c-1);
			}
		}
		if(c<n-1){
			if(!visited[r][c+1]){
				dfs(r,c+1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		visited = new boolean[n][n];
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = br.read()-48;
			}
			if(i<n-1) br.read();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j]==1&&!visited[i][j]) {
					dfs(i,j);
					list.add(cnt);
					block++;
					cnt = 0;
				}
			}
		}
		sb.append(block).append("\n");
		Collections.sort(list);
		for(int i : list){
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
 }
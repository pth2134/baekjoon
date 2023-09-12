import java.io.*;
import java.util.*;

class Main{
	static int n;
	static int m;
	static int k;
	static boolean[][] board;
	static boolean[][] visited;
	static int block = 0;

	static void dfs(int r, int c){
		visited[r][c] = true;
		if(!board[r][c]) return;
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
		if(c<m-1){
			if(!visited[r][c+1]){
				dfs(r,c+1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int l = 0; l < t; l++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			board = new boolean[n][m];
			visited = new boolean[n][m];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				board[r][c] = true;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (board[i][j]&&!visited[i][j]) {
						dfs(i,j);
						block++;
					}
				}
			}
			sb.append(block).append("\n");
			block = 0;
		}
		System.out.println(sb);
	}
 }
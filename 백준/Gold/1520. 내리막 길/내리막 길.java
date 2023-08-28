import java.io.*;
import java.util.*;

class Main{
	static int m;
	static int n;
	static int[][] height;
	static int[][] dp;
	static boolean[][] visited;

	static int dp(int y, int x){
		if(y==m&&x==n) return 1;
		if(visited[y][x]) return dp[y][x];
		visited[y][x] = true;
		int now = height[y][x];

		if(y>0&&height[y-1][x] < now) dp[y][x] += dp(y-1, x);
		if(y<m&&height[y+1][x] < now) dp[y][x] += dp(y+1, x);
		if(x>0&&height[y][x-1] < now) dp[y][x] += dp(y, x-1);
		if(x<n&&height[y][x+1] < now) dp[y][x] += dp(y, x+1);

		return dp[y][x];
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken())-1;
		n = Integer.parseInt(st.nextToken())-1;
		height = new int[m+1][n+1];
		dp = new int[m+1][n+1];
		visited = new boolean[m+1][n+1];

		for (int i = 0; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= n; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dp(0,0));
	}
 }
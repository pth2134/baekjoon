import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (br.read() == 49) graph[i][j] = true;
                br.read();
            }
        }
        long[][][] dp = new long[n + 1][n + 1][3];
        dp[1][2][0] = 1;//r=1, c=2, 가로방향이 1개
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!graph[i][j]) {
                    dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][1];
                    dp[i][j][2] += dp[i - 1][j][1] + dp[i - 1][j][2];
                    if (!graph[i - 1][j] && !graph[i][j - 1]) {
                        dp[i][j][1] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                    }
                }
            }
        }

        System.out.println(dp[n][n][0]+dp[n][n][1]+dp[n][n][2]);
    }
}
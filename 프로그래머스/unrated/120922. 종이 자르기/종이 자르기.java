class Solution {
    public int solution(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            dp[i][1] = i-1;
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i] = i-1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i][1]+dp[i][j-1]+1;
                for (int k = 2; k <= j/2; k++) {
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[i][j-k]+1);
                }
                for (int k = 1; k <= i/2 ; k++) {
                    dp[i][j] = Math.min(dp[i][j],dp[k][j]+dp[i-k][j]+1);
                }
            }
        }

        return dp[m][n];
    }
}
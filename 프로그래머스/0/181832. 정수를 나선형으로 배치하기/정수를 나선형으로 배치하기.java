class Solution {
    static int[] direction = {1,1,-1,-1};
    static int[][] map;
    static int n;
    
    public int[][] solution(int n) {
        Solution.n = n;
        map = new int[n][n];
        dfs(true, 0, 0, 0, 1);
        return map;
    }
    
    public void dfs(boolean isRow, int curveCnt, int c, int r, int now) {
        map[c][r] = now;
        int d = direction[curveCnt%4];
        if(isRow) {
            int next = r + d;
            if(next >= 0 && next < n && map[c][next] == 0) {
                dfs(isRow, curveCnt, c, next, now + 1);
            } else {
                d = direction[++curveCnt%4];
                next = c + d;
                if(next < n && map[next][r] == 0) dfs(!isRow, curveCnt, next, r, now + 1);
            }
        } else {
            int next = c + d;
            if(next >= 0 && next < n && map[next][c] == 0) {
                dfs(isRow, curveCnt, next, r, now + 1);
            } else {
                d = direction[++curveCnt%4];
                next = r + d;
                if(next < n && map[c][next] == 0) dfs(!isRow, curveCnt, c, next, now + 1);
            }
        }
    }
}
class Solution {
    public int solution(int n) {
        boolean[] visited = new boolean[n+1];
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i*2; j <= n; j+=i) {
                if(!visited[j]) {
                    visited[j] = true;
                    answer++;
                }
            }
        }
        return answer;
    }
}
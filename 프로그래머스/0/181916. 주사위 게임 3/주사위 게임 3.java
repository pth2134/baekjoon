import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[][] cnt = new int[7][2];

        for (int i = 1; i < 7; i ++) {
            cnt[i][0] = i;
        }

        cnt[a][1]++;
        cnt[b][1]++;
        cnt[c][1]++;
        cnt[d][1]++;

        Arrays.sort(cnt, (o1, o2) -> o2[1] - o1[1]);

        int answer = 0;

        if(cnt[0][1] == 4) {
            answer = 1111 * cnt[0][0];
        } else if(cnt[0][1] == 3) {
            int temp = 10 * cnt[0][0] + cnt[1][0];
            answer = (int) Math.pow(temp,2);
        } else if(cnt[0][1] == 2) {
            if(cnt[1][1] == 2) {
                answer = (cnt[0][0] + cnt[1][0]) * Math.abs(cnt[0][0] - cnt[1][0]);
            } else {
                answer = cnt[1][0] * cnt[2][0];
            }
        } else {
            answer = 6;
            for (int i = 0; i < 4; i++) {
                if(cnt[i][0] < answer) answer = cnt[i][0];
            }
        }

        return answer;
    }
}
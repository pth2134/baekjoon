import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static int[] solution(int n, int s) {
        int[] answer;
        ArrayList<Integer[]> list = new ArrayList<>();
        int m = s/n;
        if(m<1) answer = new int[]{-1};
        else {
            answer = new int[n];
            int d = s-m*n;
            for (int i = 0; i < n-d; i++) {
                answer[i] = m;
            }
            for (int i = n-d; i <n; i++) {
                answer[i] = m+1;
            }
        }

        return answer;
    }

}
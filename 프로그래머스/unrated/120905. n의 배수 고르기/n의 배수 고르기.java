import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int m = numlist.length;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if(numlist[i]%n==0) que.add(numlist[i]);
        }
        
        int[] answer = new int[que.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = que.poll();
        }
        return answer;
    }
}
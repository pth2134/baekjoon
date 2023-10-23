class Solution {
    public int solution(int[] dot) {
        boolean x = dot[0]>0;
        boolean y = dot[1]>0;
        int answer = 0;
        if(x&&y) answer = 1;
        else if (y) answer = 2;
        else if (x) answer = 4;
        else answer = 3;
        return answer;
    }
}
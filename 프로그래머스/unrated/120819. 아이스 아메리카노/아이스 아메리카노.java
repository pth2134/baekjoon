class Solution {
    public int[] solution(int money) {
        int n = money/5500;
        int[] answer = {n,money-n*5500};
        return answer;
    }
}
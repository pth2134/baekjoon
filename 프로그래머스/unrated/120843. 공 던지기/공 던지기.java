class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int l = numbers.length;
        for (int i = 1; i < k; i++) {
            answer = (answer+2)%l;
        }
        return answer+1;
    }
}
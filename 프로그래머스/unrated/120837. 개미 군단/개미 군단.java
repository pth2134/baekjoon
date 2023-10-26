class Solution {
    public int solution(int hp) {
        int g = hp%5;
        int s = g%3;
        int answer = hp/5+g/3+s;
        return answer;
    }
}
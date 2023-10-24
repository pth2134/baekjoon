class Solution {
    public int solution(int n) {
        for(int i = n; i < 600; i++){
            if(i%6==0&&i%n==0) return i/6;
        }
        return -1;
    }
}
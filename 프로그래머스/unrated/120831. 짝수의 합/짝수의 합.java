class Solution {
    public int solution(int n) {
        if(n%2==1) n--;
        int answer = (n+2)*((n-2)/2+1)/2;
        return answer;
    }
}
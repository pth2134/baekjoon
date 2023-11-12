class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int l = i; l <= j; l++) {
            int n = l;
            while(n>0){
                if(n%10==k) {
                    answer++;
                }
                n/=10;
            }
        }

        return answer;
    }
}
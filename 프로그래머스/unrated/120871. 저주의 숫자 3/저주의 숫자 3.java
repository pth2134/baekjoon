class Solution {
    public int solution(int n) {
        int cnt = 0;
        int num = 0;
        while (cnt<n){
            num++;
            if(num%3==0) continue;
            if((num+"").contains("3")) continue;
            cnt++;
        }
        return num;
    }
}
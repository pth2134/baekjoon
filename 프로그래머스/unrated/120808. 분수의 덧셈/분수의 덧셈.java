class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int n = numer1*denom2+denom1*numer2;
        int d = denom1*denom2;
        for(int i = 2; i<= n; i++){
            while(n%i==0&&d%i==0){
                n/=i;d/=i;
            }
        }
        int[] answer = {n,d};
        return answer;
    }
}
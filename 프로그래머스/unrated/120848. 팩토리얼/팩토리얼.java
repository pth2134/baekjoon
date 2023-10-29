class Solution {
    public static int solution(int n) {
        int answer = 0;
        int low = 1;
        int hi = n;
        long mid;
        while(low<hi){
            mid = (low+hi)/2;
            long f = mid;
            long m = mid;
            while(f<=n&&m>2){
                f*=--m;
            }
            if(f>n) {
                hi = (int) mid;
            } else{
                low = (int) mid+1;
            }
        }
        return n>2? low-1:n;
    }
}
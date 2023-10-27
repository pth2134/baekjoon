class Solution {
    public static long solution(long balls, long share) {
        long r = Math.min(share, balls - share);
        long mult = 1, div = 1, r2;
        for (int i = 0; i < r; i++) {
            mult *= balls--;
            r2 = i + 1;
            if (mult % r2 == 0) mult /= r2;
            else div *= r2;
        }
        return mult/div;
    }
}

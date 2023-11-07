import java.util.Arrays;

class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots,(o1, o2) -> {
            if(o1[0]==o2[0])return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        int width = dots[3][0]-dots[0][0];
        int height = dots[1][1]-dots[0][1];
        return width*height;
    }
}
import java.util.Arrays;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        Arrays.sort(dots,(o1,o2)-> o2[0]-o1[0]); //x로 내림차순
        answer = linear(dots);
        Arrays.sort(dots,(o1,o2)-> o2[1]-o1[1]); //y로 내림차순
        answer = Math.max(answer,linear(dots));
        return answer;
    }

    public int linear(int[][] a){
        int dx1 = a[0][0] - a[1][0];
        int dx2 = a[2][0] - a[3][0];
        if(dx1==0&&dx2==0) return 1;
        if(dx1==0^dx2==0) return 0;
        int dy1 = a[0][1]-a[1][1];
        int dy2 = a[2][1]-a[3][1];
        if(dy1==0&&dy2==0) return 1;
        if(dy1==0^dy2==0) return 0;
        if(dy1*dx2==dx1*dy2||dy1*dx2==-dx1*dy2) return 1;
        return 0;
    }

}
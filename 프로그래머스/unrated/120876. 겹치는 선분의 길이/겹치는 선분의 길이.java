import java.util.Arrays;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        Arrays.sort(lines,(o1,o2)->o1[1]-o2[1]);

        int[] line1 = same(lines[0],lines[1]);
        int[] line2 = same(lines[1],lines[2]);
        int[] line3 = same(lines[0],lines[2]);

        if(!(line3[0]==0&&line3[1]==0)){
            if(line1[0]==0&&line1[1]==0){
                line1=line3;
            } else{
                line1[0] = Math.min(line1[0],line3[0]);
                line1[1] = Math.max(line1[1],line3[1]);
            }
        }
        if(line1[1]>line2[0]) answer-= line1[1]-line2[0];
        answer+= line1[1]-line1[0];
        answer+= line2[1]-line2[0];
        return answer;
    }

    public int[] same(int[] a, int[] b){
        int start = b[0]>a[0]? b[0]:a[0];
        int end = a[1];

        return end-start>0? new int[]{start,end}:new int[]{0,0};
    }
}
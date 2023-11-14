class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int gap = common[1] - common[0];
        if(common[1]+gap == common[2] ){
            answer = common[common.length-1]+gap;
        }else{
            answer = common[common.length-1]*common[1]/common[0];
        }
        return answer;
    }
}
class Solution {
    public int solution(int[] array, int n) {
        int minGap = 100;
        int answerIdx = 0;
        for(int i = 0; i<array.length; i++){
            int gap = Math.abs(n-array[i]);
            if(minGap > gap){
                minGap = gap;
                answerIdx = i; 
            } else if(minGap == gap&&array[answerIdx]>array[i]){
                answerIdx = i;
            }
        }
        return array[answerIdx];
    }
}
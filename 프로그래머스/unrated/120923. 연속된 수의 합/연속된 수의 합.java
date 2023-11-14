class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int sum = total*2;
        int mid = sum/num/2;
        if(num%2==0){
            for(int i =0; i<num; i++){
                answer[i] = mid-num/2+1+i;
            }
        } else {
            for(int i =0; i<num; i++){
                answer[i] = mid-num/2+i;
            }
        }
        return answer;
    }
}
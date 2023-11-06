class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i =0; i<array.length; i++){
            if(array[i]%10==7) answer++;
            if(array[i]/10%10==7) answer++;
            if(array[i]/100%10==7) answer++;
            if(array[i]/1000%10==7) answer++;
            if(array[i]/10000%10==7) answer++;
        }
        return answer;
    }
}
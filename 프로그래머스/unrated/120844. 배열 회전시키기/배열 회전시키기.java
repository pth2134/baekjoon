class Solution {
    public int[] solution(int[] numbers, String direction) {
        int start = 0;
        int l = numbers.length;
        if(direction.equals("right")) start = l-1;
        else start++;
        
        int[] answer = new int[l];
        for (int i = 0; i < l; i++) {
            answer[i] = numbers[(i+start)%l]; 
        }
        return  answer;
    }
}
class Solution {
    public String solution(String s) {
        int[] ap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ap[s.charAt(i)-97]++;
        }
        String answer = "";
        for (int i = 0; i < 26; i++) {
            if(ap[i]==1){
               answer += (char) (i+97);
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(String before, String after) {
        int[] alp = new int[26];
        for (int i = 0; i < before.length(); i++) {
            alp[before.charAt(i)-97]++;
        }
        for (int i = 0; i < after.length(); i++) {
            if(alp[after.charAt(i)-97]--==0) return 0;
        }
        for (int i = 0; i < 26; i++) {
            if(alp[i]!=0) return 0;
        }
        return 1;
    }
}
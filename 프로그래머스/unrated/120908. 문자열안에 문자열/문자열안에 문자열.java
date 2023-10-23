class Solution {
    public int solution(String str1, String str2) {
        int str2_length = str2.length();
        int str1_range = str1.length()-str2_length;
        for (int i = 0; i <= str1_range; i++) {
            if(str1.charAt(i)==str2.charAt(0)){
                for (int j = 0; j < str2_length; j++) {
                    if(str1.charAt(i+j)!=str2.charAt(j)) break;
                    if(j==str2_length-1) return 1;
                }
            }
        }
        return 2;
    }
}
class Solution {
    public int solution(String A, String B) {
        for (int i = 0; i < B.length(); i++) {
            if(B.charAt(i)==A.charAt(0)) if(A.equals(B.substring(i,B.length())+B.substring(0,i))){
                return i;
            }
        }
        return -1;
    }
}
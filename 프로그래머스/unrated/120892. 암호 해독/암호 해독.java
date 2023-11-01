class Solution {
    public String solution(String cipher, int code) {
        char[] c = new char[cipher.length()/code];
        int idx = 0;
        for(int i =code-1; i< cipher.length(); i+=code){
            c[idx++] = cipher.charAt(i);
        }
        return new String(c);
    }
}
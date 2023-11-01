class Solution {
    public String solution(String my_string) {
        char[] c = new char[my_string.length()];
        for (int i = 0; i < c.length; i++) {
            char input =my_string.charAt(i);
            if(65<=input&&input<=90 ){
                c[i] = (char) (input + 32);
            }else{
                c[i] = (char) (input - 32);
            }
        }
        return new String(c);
    }
}
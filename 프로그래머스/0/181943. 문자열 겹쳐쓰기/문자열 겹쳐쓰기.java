class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] my_chars = my_string.toCharArray();
        for (int i = 0; i < overwrite_string.length(); i++) {
            my_chars[s + i] = overwrite_string.charAt(i);
        }
        return new String(my_chars);
    }
}
class Solution {
    public String solution(String my_string) {
        String[] str = my_string.split("a|e|i|o|u");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
import java.util.HashSet;

class Solution {
    public String solution(String my_string) {
        HashSet<Character> set = new HashSet<>();
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            char input = my_string.charAt(i);
            if(!set.contains(input)){
                set.add(input);
                answer += input;
            }
        }
        return answer;
    }
}
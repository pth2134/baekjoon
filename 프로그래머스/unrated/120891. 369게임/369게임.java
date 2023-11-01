import java.util.HashSet;

class Solution {
    public int solution(int order) {
        HashSet<Character> set = new HashSet<>();
        set.add('3');
        set.add('6');
        set.add('9');
        String str = order +"";
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if(set.contains(str.charAt(i))) answer++;
        }
        return answer;
    }
}
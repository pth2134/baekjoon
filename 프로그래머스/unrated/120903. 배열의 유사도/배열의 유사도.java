import java.util.HashSet;

class Solution {
    public int solution(String[] s1, String[] s2) {
        HashSet<String> set = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < s1.length; i++) {
            set.add(s1[i]);
        }
        for (int i = 0; i < s2.length; i++) {
            if(set.contains(s2[i])) answer++;
        }
        return answer;
    }
}
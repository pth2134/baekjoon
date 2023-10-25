class Solution {
    public static int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            String s = babbling[i];
            for (int j = 0; j < 4; j++) {
                s = s.replace(words[j]," ");
            }
            s = s.replaceAll(" ","");
            if (s.length()==0) answer++;
        }
        return answer;
    }
}
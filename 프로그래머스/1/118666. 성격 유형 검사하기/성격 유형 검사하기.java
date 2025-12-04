import java.util.HashMap;
class Solution {
    public String solution(String[] survey, int[] choices) {
        char[][] mbti = {{'R','T'}, {'C','F'}, {'J','M'}, {'A','N'}};
        int[] score = new int[4];
        HashMap<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            map.put(mbti[i][0], new int[]{i, -1});
            map.put(mbti[i][1], new int[]{i, 1});
        }

        for (int i = 0; i < survey.length; i++) {
            int[] dest = map.get(survey[i].charAt(1));
            score[dest[0]] += dest[1] * (choices[i] - 4);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(score[i] > 0 ? mbti[i][1] : mbti[i][0]);
        }
        return sb.toString();
    }
}
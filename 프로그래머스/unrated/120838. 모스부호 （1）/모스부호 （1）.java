import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public String solution(String letter) {
        HashMap<String,Character> map = new HashMap<>();
        String[] mos = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (int i = 0; i < mos.length; i++) {
            map.put(mos[i],(char) (i+97));
        }
        StringTokenizer st = new StringTokenizer(letter);
        int size = st.countTokens();
        char[] answer = new char[size];
        for (int i = 0; i < size; i++) {
            answer[i] = map.get(st.nextToken());
        }
        return new String(answer);
    }
}

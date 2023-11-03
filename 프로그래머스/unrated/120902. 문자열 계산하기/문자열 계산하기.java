import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    public static int solution(String my_string) {
        Queue<Character> qc = new LinkedList<>();
        for (int i = 0; i < my_string.length(); i++) {
            char input = my_string.charAt(i);
            if(input=='+'||input=='-'){
                qc.add(input);
            }
        }
        StringTokenizer st = new StringTokenizer(my_string,"+,-, ");
        int answer = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()){
            char c = qc.poll();
            if(c=='+'){
                answer+=Integer.parseInt(st.nextToken());
            } else{
                answer-=Integer.parseInt(st.nextToken());
            }
        }
        return answer;
    }
}
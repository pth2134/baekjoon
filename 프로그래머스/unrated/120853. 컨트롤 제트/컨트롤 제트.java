import java.util.StringTokenizer;

class Solution {
    public int solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int pre = Integer.parseInt(st.nextToken());
        int answer = pre;
        while(st.hasMoreTokens()){
            String input = st.nextToken();
            if(input.equals("Z")){
                answer -= pre;
            } else {
                pre = Integer.parseInt(input);
                answer+=pre;
            }
        }
        return answer;
    }
}
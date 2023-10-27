class Solution {
    public String solution(String rsp) {
        char[] answer = new char[rsp.length()];
        for (int i = 0; i < rsp.length(); i++) {
            char key = rsp.charAt(i);
            switch (key) {
                case '0':
                    answer[i] = '5';
                    break;
                case '2':
                    answer[i] = '0';
                    break;
                case '5':
                    answer[i] = '2';
                    break;
            }
        }
        return new String(answer);
    }
}
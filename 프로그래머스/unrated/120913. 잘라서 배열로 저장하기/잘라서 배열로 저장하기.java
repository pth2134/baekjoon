class Solution {
    public String[] solution(String my_str, int n) {
        int m = my_str.length()/n;
        int m2 = my_str.length()%n;
        String[] answer;
        if(m2==0) answer = new String[m];
        else answer = new String[m+1];
        int start = 0;
        for (int i = 0; i < m; i++) {
            answer[i] = my_str.substring(start,start+n);
            start += n;
        }
        if(m2!=0) answer[m] = my_str.substring(start,my_str.length());
        return answer;
    }
}
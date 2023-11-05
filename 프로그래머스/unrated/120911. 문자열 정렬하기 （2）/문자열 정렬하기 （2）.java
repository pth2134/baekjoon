class Solution {
    public String solution(String my_string) {
        int[] alp = new int[26];
        int l = 0;
        for (int i = 0; i < my_string.length(); i++) {
            int c = my_string.charAt(i);
            if(c<97) c-=65;
            else c-=97;
            alp[c]++;
            l++;
        }
        char[] result = new char[l];
        int idx = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alp[i]; j++) {
                result[idx++]=(char)(i+97);
            }
        }
        return new String(result);
    }
}
class Solution {
    public int solution(int num, int k) {
        String str = num+"";
        int l = str.length();
        char c = (char)(k+48);
        for (int i = 0; i < l; i++) {
            if(str.charAt(i)==c){
                return i+1;
            }
        }
        return -1;
    }
}
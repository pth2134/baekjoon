class Solution {
    public String solution(String bin1, String bin2) {
        int[] binary_mult = new int[11];
        binary_mult[0] = 1;
        for (int i = 1; i <= 10; i++) {
            binary_mult[i] = binary_mult[i - 1] * 2;
        }
        int sum = 0;
        int l = bin1.length()-1;
        for (int i = bin1.length() - 1; i >= 0; i--) {
            sum += (bin1.charAt(l-i) - 48) * binary_mult[i];
        }
        l = bin2.length()-1;
        for (int i = bin2.length() - 1; i >= 0; i--) {
            sum += (bin2.charAt(l-i) - 48) * binary_mult[i];
        }
        String answer = "";
        int n = 0;
        for (int i = 10; i >=0 ; i--) {
            if(sum>=binary_mult[i]) {
                n=i;
                break;
            }
        }
        for (int i = n; i >= 0; i--) {
            if (sum >= binary_mult[i]) {
                sum -= binary_mult[i];
                answer += "1";
            } else answer += "0";
        }
        return answer;
    }
}
class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] a = my_string.toCharArray();
        char temp = a[num1];
        a[num1] = a[num2];
        a[num2] = temp;
        return new String(a);
    }
}
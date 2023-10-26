class Solution {
    public static String solution(int age) {
        char[] a = (age+"").toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i]+=49;
        }
        return new String(a);
    }
}
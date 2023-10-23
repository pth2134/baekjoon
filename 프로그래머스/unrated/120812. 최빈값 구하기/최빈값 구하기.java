class Solution {
    public int solution(int[] array) {
        int[] array_cnt = new int[1000];
        int max_val = 0;
        int max_cnt = 0;
        boolean d = false;
        for (int i = 0; i < array.length; i++) {
            int input = array[i];
            array_cnt[input]++;
            if(array_cnt[input]>max_cnt) {
                max_cnt = array_cnt[input];
                max_val = input;
                d = false;
            }
            else if (array_cnt[input]==max_cnt) d = true;
        }
        if(!d) return max_val;
        else return -1;
    }
}
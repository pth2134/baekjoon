class Solution {
    public int[] solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if(a>=50&&a%2==0) arr[i]/=2;
            else if(a<50&&a%2==1) arr[i]*=2;
        }
        return arr;
    }
}
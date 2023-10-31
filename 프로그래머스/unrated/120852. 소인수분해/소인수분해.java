import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if(n%i==0){
                list.add(i);
                while(n%i==0){
                    n/=i;
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
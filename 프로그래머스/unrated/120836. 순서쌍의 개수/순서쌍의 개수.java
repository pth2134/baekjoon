import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return (int) IntStream.rangeClosed(1,n).filter(e -> n%e==0).count();
    }
}
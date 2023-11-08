class Solution {
    public int solution(String my_string) {
        int sum = 0;
        int intVal = 0;
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (c>=48&&c<=57){
                intVal*=10;
                intVal+= c-48;
            }
            else{
                sum+=intVal;
                intVal=0;
            }
        }
        return sum + intVal;
    }
}
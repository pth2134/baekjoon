import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Character,Integer> signMap = new HashMap<>(){{
        put('I',1);
        put('V',5);
        put('X',10);
        put('L',50);
        put('C',100);
        put('D',500);
        put('M',1000);
    }};

    static HashMap<Integer, Character> valueMap = new HashMap<>(){{
        put(1, 'I');
        put(5, 'V');
        put(10, 'X');
        put(50, 'L');
        put(100, 'C');
        put(500, 'D');
        put(1000, 'M');
    }};
    static StringBuilder sb = new StringBuilder();

    static int signToValue(String s){
        int l = s.length();
        int sum = 0;
        int pre = 10000;
        for (int i = 0; i < l; i++) {
            int value = signMap.get(s.charAt(i));
            sum+=value;
            if(value > pre) {
                sum-=pre*2;
            }
            pre = value;
        }
        return sum;
    }

    static void valueTosign(int v){
        for (int i = 1000; i >=1 ; i/=10) {
            int n = v/i;
            v-= n*i;
            if(n==4||n==9) {
                int n2 = (n+1)*i;
                sb.append(valueMap.get(n2/(n+1))).append(valueMap.get(n2));
            }
            else{
                if(n>=5) {
                    sb.append(valueMap.get(5*i));
                    n-=5;
                }
                while(n>0) {
                    sb.append(valueMap.get(i));
                    n--;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = signToValue(br.readLine());
        int b = signToValue(br.readLine());
        int c = a+b;
        sb.append(c).append("\n");
        valueTosign(c);
        System.out.println(sb);
    }
}

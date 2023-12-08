import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int half = str.length()/2;
        int length = str.length()-1;
        boolean isUnified = true;
        boolean isOdd = length%2==0;

        if(str.charAt(0)!=str.charAt(length)) {
            System.out.println(length+1);
            return;
        }

        char pre = str.charAt(0);
        for (int i = 1; i < half; i++) {
            char a = str.charAt(i);
            if(a ==str.charAt(length-i)) {
                if (pre!=a) isUnified = false;
                pre = a;
            } else {
                System.out.println(length+1);
                return;
            }
        }
        if(isOdd&&pre!=str.charAt(half)) isUnified = false;
        if (isUnified) System.out.println(-1);
        else System.out.println(length);
    }
}
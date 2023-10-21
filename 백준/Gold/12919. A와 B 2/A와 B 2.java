import java.io.*;
import java.util.*;

public class Main {
    static String s1;
    static String s2;
    static int length;
    static boolean answer = false;

    static void b_to_a(int start, int last, boolean reverse) {
        if (last - start == length) {
            if (!reverse) {
                if (s1.equals(s2.substring(start, last + 1))) answer = true;
            } else {
                StringBuilder sb = new StringBuilder(s2.substring(start, last + 1));
                if (s1.equals(sb.reverse().toString())) answer = true;
            }
            return;
        }
        if (!reverse) {
            if (s2.charAt(last) == 'A') {
                b_to_a(start, last - 1, reverse);
            }
            if (s2.charAt(start) == 'B') {
                b_to_a(start + 1, last, !reverse);
            }
        } else {
            if (s2.charAt(start) == 'A') {
                b_to_a(start + 1, last, reverse);
            }
            if (s2.charAt(last) == 'B') {
                b_to_a(start, last - 1, !reverse);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        s1 = br.readLine();
        s2 = br.readLine();
        length = s1.length() - 1;
        boolean reverse = false;
        b_to_a(0, s2.length() - 1, false);
        if (answer) System.out.println(1);
        else System.out.println(0);
    }
}

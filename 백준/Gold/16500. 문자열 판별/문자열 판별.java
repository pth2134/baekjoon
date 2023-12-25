import java.io.*;
import java.util.*;

public class Main {
    static String s;
    static int length;
    static boolean[] dp;
    static int n;
    static HashSet<String> a = new HashSet<>();

    public static void verify(int start, int last) {
        if(start<0) return;
        if (a.contains(s.substring(start, last))&&!dp[start]) {
            dp[start] = true;
            verify(start - 1, start);
        }
        verify(start - 1, last);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        length = s.length();
        dp = new boolean[length];
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(br.readLine());
        }
        verify(length-1,length);
        if(dp[0]) System.out.println(1);
        else System.out.println(0);
    }

}
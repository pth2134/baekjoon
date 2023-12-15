import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        if(b>=c) System.out.println(-1);
        else {
            long d = c-b;
            long e = a/d;
            System.out.println(e+1);
        }
    }
}
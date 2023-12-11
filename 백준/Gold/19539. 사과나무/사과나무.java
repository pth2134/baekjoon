import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        long two_cnt = 0;
        for (int i = 0; i < n; i++) {
            long tree = Long.parseLong(st.nextToken());
            sum+= tree;
            two_cnt+=tree/2;
        }
        long max = two_cnt*2+two_cnt;
        if(max>=sum&&sum%3==0) System.out.println("YES");
        else System.out.println("NO");
    }
}
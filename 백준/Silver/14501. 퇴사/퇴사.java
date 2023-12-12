import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n+1];
        int[] p = new int[n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken())+i-1; //이 날 까지 일함
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i],dp[i-1]);
            if(t[i]<=n) dp[t[i]] = Math.max(dp[t[i]],dp[i-1]+p[i]);
        }
        System.out.println(dp[n]);
    }
}
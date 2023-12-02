import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int b = (int) Math.sqrt(i);
            for (int j = 1; j <= b; j++) {
                int c = j*j;
                int d = 1+dp[i-c];
                if(d == 1) {
                    dp[i] = 1;
                    continue;
                }
                if(dp[i]!=0) dp[i] = Math.min(d,dp[i]);
                else dp[i] = d;
            }
        }
        System.out.println(dp[n]);
    }
}
import java.io.*;

class Main {
    static int[][] dp = new int[41][2];
    static int n;

    static int[] fibo(int n){
        if(n>=2&&dp[n][0]!=0){
            return dp[n];
        } if(n==1){
            return dp[1];
        } else if(n==0){
            return dp[0];
        } else{
            dp[n-1] = fibo(n-1);
            dp[n-2] = fibo(n-2);
            dp[n][0] = dp[n-1][0]+dp[n-2][0];
            dp[n][1] = dp[n-1][1]+dp[n-2][1];
            return dp[n];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            sb.append(fibo(n)[0]+" ").append(dp[n][1]+"\n");
        }
        System.out.println(sb);
    }
}
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long mult = 1;
        int zero = 0;
        for (int i = 2; i <= n; i++) {
            mult*=i;
            mult%=1000000000;
            while(mult%10==0) {
                mult/=10;
                zero++;
            }
        }
        System.out.println(zero);
    }
}
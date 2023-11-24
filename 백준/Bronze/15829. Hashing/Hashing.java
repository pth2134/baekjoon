import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long l = Long.parseLong(br.readLine());
        long n = 1;
        long m = 1234567891;
        long sum = 0;
        for (int i = 0; i < l; i++) {
           long input = br.read()-96;
           sum+=input*n; sum%=1234567891;
           n=n*31%1234567891;
        }
        System.out.println(sum);
    }
}
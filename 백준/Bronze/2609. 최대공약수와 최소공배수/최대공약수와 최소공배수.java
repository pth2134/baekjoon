import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = Math.min(n,m);
        int lcm = n*m;
        int gcf = 1;

        for (int i = 2; i <= min; i++) {
            while(n%i==0&&m%i==0){
                gcf*=i;
                n/=i; m/=i;
            }
        }

        System.out.println(gcf);
        System.out.println(lcm/gcf);
    }
}

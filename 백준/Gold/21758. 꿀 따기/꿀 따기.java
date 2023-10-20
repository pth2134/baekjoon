import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] h = new long[n]; //idx에 있는 꿀
        long[] f = new long[n]; //0~idx까지 있는 꿀
        h[0] = Long.parseLong(st.nextToken());
        f[0] = h[0];
        long max_for_m = 0; //벌집이 가운데 있을 경우에 사용
        for (int i = 1; i < n - 1; i++) {
            h[i] = Long.parseLong(st.nextToken());
            f[i] = f[i - 1] + h[i];
            max_for_m = Math.max(max_for_m, h[i]);
        }
        h[n - 1] = Long.parseLong(st.nextToken());
        f[n - 1] = f[n - 2] + h[n - 1];

        //벌집이 오른쪽에 있는 경우
        int i = 0, j = 1, k = n - 1;
        long d = 0;
        long sum = 2 * (f[k] - f[j]);
        long max_for_r = 0;
        for (int l = 2; l < n - 1; l++) {
            d = h[j] - h[l] - f[l] + f[j];
            max_for_r = Math.max(max_for_r, d);
        }
        long max = sum + max_for_r;
        //벌집이 왼쪽에 있는 경우
        i = n - 2;
        j = n - 1;
        k = 0;
        d = 0;
        sum = 2 * f[i - 1];
        long max_for_l = 0;
        for (int l = n - 3; l > 0; l--) {
            d = h[i] - h[l] - f[i - 1] + f[l - 1];
            max_for_l = Math.max(max_for_l, d);
        }
        max = Math.max(max, sum + max_for_l);
        //벌집이 중간에 있는 경우;
        max = Math.max(max,f[n-2]-h[0]+max_for_m);
        System.out.println(max);
    }
}

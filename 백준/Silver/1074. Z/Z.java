import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] group = new int[n][2];
        group[0][1] = 1;
        for (int i = 0; i < n; i++) {
            try {
                group[i][1] = group[i - 1][1] * 4;
            } catch (ArrayIndexOutOfBoundsException aiob) {
            }
            if (r % 2 == 0 && c % 2 == 0) group[i][0] = 0;
            else if (r % 2 == 0) group[i][0] = 1;
            else if (c % 2 == 0) group[i][0] = 2;
            else group[i][0] = 3;
            r /= 2;
            c /= 2;
        }
        int order = 0;
        for (int i = n-1; i >=0; i--) {
            order+=group[i][0]*group[i][1];
        }
        System.out.println(order);
    }
}
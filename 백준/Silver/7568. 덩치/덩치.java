import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] big = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            big[i][1] = Integer.parseInt(st.nextToken());
            big[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int level = 1;
            int weight = big[i][1];
            int height = big[i][2];
            for (int j = 0; j < n; j++) {
                if(weight<big[j][1]&&height<big[j][2]) level++;
            }
            big[i][0] = level;
            sb.append(level).append(" ");
        }
        System.out.println(sb);
    }
}

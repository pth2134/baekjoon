import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            if(n>32) {
                sb.append(0).append("\n");
                continue;
            }
            String[] mbti = new String[n];
            int[][] dis = new int[n][n];
            for (int j = 0; j < n; j++) {
                mbti[j] = st.nextToken();
            }

            int min = 12;

            for (int j = 0; j < n-2; j++) {
                String a = mbti[j];
                for (int k = j+1; k < n-1; k++) {
                    String b = mbti[k];
                    for (int l = k+1; l < n; l++) {
                        String c = mbti[l];
                        int cnt = 0;
                        for (int m = 0; m < 4; m++) {
                            if(a.charAt(m)!=b.charAt(m)) cnt++;
                            if(b.charAt(m)!=c.charAt(m)) cnt++;
                            if(a.charAt(m)!=c.charAt(m)) cnt++;
                        }
                        min = Math.min(min, cnt);
                    }
                }
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
}

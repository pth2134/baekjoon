import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] water = new int[n][2];
        int cover_last = 0;
        int cover_range = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            water[i][0] = Integer.parseInt(st.nextToken());
            water[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(water, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            int from = water[i][0];
            int to = water[i][1];
            if (cover_last < to) {
                int cover_start = Math.max(cover_last, from);
                cover_range = to - cover_start;
                int need = (cover_range + l - 1) / l;
                cover_last = cover_start + need * l;
                cnt += need;
            }
        }
        System.out.println(cnt);
    }
}
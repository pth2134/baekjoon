import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[] base = new long[K + 1];
        long[] s = new long[K + 1];
        long[] p = new long[K + 1];
        long[] skill = new long[K + 1];

        // base input
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            base[i] = Long.parseLong(st.nextToken());
        }

        // s input
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            s[i] = Long.parseLong(st.nextToken());
        }

        // p input
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            p[i] = Long.parseLong(st.nextToken());
        }

        long stardust = 0;
        long tired = 0;
        long combo = 0;

        for (int day = 0; day < N; day++) {
            int skill_num = Integer.parseInt(br.readLine());

            if (skill_num == 0) {
                // 휴식
                tired = Math.max(0, tired - R);
                combo = 0;
                continue;
            }

            tired += p[skill_num];
            if (tired > 100) {
                System.out.println(-1);
                return;
            }

            // Stardust calculation
            long deltaStardust = (base[skill_num] * (100 + combo * C) * (100 + skill[skill_num] * s[skill_num])) / 10000;
            stardust += deltaStardust;

            combo++;
            skill[skill_num]++;
        }

        System.out.println(stardust);
    }
}
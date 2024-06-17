import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();  // 캐릭터의 수
        int m = reader.nextInt();  // 하루에 사용할 캐릭터의 수
        int k = reader.nextInt();  // 보스의 가짓수
        long[][] boss = new long[k + 1][2];  // 보스의 체력과 메소

        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(reader.nextLong());  // 캐릭터의 데미지
        }

        for (int i = 1; i <= k; i++) {
            boss[i][0] = reader.nextLong();  // 보스의 체력
            boss[i][1] = reader.nextInt();   // 보스의 메소 (여전히 int 범위 내)
        }

        long total = 0;

        for (int i = 0; i < m; i++) {
            if (pq.isEmpty()) {
                throw new IllegalStateException("우선순위 큐가 비어 있습니다.");
            }
            long dps = pq.poll();

            long[] time = new long[k + 1];
            long[][] dp = new long[k + 1][901];

            for (int j = 1; j <= k; j++) {
                time[j] = boss[j][0] / dps;
                if (boss[j][0] % dps != 0)
                    time[j]++;
            }

            for (int j = 1; j <= k; j++) {
                for (int l = 1; l <= 900; l++) {
                    if (time[j] > l) {
                        dp[j][l] = dp[j - 1][l];
                    } else {
                        // l - time[j]가 음수가 되지 않도록 확인
                        if (l >= time[j]) {
                            dp[j][l] = Math.max(dp[j - 1][l], dp[j - 1][(int) (l - time[j])] + boss[j][1]);
                        } else {
                            dp[j][l] = dp[j - 1][l];
                        }
                    }
                }
            }

            total += dp[k][900];
        }

        System.out.println(total);
    }

    static class Reader {
        final int SIZE = 1 << 15;
        byte[] buffer = new byte[SIZE];
        int index, size;

        int nextInt() throws IOException {
            int n = 0;
            byte c;
            while ((c = read()) <= 32);
            boolean neg = c == '-';
            if (neg) c = read();
            do n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
            return neg ? -n : n;
        }

        long nextLong() throws IOException {
            long n = 0;
            byte c;
            while ((c = read()) <= 32);
            boolean neg = c == '-';
            if (neg) c = read();
            do n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
            return neg ? -n : n;
        }

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        byte read() throws IOException {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0) buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}

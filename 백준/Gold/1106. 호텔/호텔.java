import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int c = reader.nextInt();
        int n = reader.nextInt();

        int[] dp = new int[100_001];
        int[][] costValue = new int[n][2];

        for (int i = 0; i < n; i++) {
            costValue[i][0] = reader.nextInt();
            costValue[i][1] = reader.nextInt();
        }

        Arrays.sort(costValue, (o1, o2) -> o1[0] - o2[0]); //작은게 앞쪽

        int i = 1;
        while (dp[i - 1] < c) {
            for (int j = 0; j < n && costValue[j][0] <= i; j++) {
                int cost = costValue[j][0];
                int value = costValue[j][1];
                dp[i] = Math.max(dp[i], dp[i - cost] + value);
            }
            i++;
        }

        System.out.println(i - 1);
    }


    static class Reader {
        final int SIZE = 1 << 15;
        byte[] buffer = new byte[SIZE];
        int index, size;

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        int nextInt() throws IOException {
            int n = 0;
            byte c;
            while ((c = read()) <= 32) ;
            boolean neg = c == '-';
            if (neg) c = read();
            do n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
            return neg ? -n : n;
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
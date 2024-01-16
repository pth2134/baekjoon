import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] result = new int[5];

            result[0] += n / 60;
            n %= 60;
            if (n >= 36) {
                result[0]++;
                n -= 60;
            }

            if (n < 0) {
                result[2] -= n / 10;
                n += result[2] * 10;
                if (n <= -6) {
                    result[2]++;
                    result[3] = 10 + n;
                } else result[4] -= n;
            } else {
                result[1] += n / 10;
                n %= 10;
                if (n >= 6) {
                    result[1]++;
                    result[4] += 10 - n;
                } else result[3] += n;
            }

            for (int j = 0; j < 5; j++) {
                sb.append(result[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}

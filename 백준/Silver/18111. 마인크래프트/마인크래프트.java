import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] height = new int[n * m];
        int last = n * m - 1;
        int min = Integer.MAX_VALUE;
        int max = 0;
        int minTime = min;
        int flatHeight = 0;

        int k = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                height[k] = Integer.parseInt(st.nextToken());
                if (height[k] > max) max = height[k];
                if (height[k] < min) min = height[k];
                k++;
            }
        }
        for (int i = min; i <= max; i++) {
            int c = b;
            int time = 0;
            int gap = 0;
            for (int j = 0; j <= last; j++) {
                if (height[j] < i) {
                    gap = i - height[j];
                    c -= gap;
                    time += gap;
                } else {
                    gap = height[j] - i;
                    c += gap;
                    time += gap * 2;
                }
            }
            if(c<0) break;
            if(minTime >= time){
                minTime = time;
                flatHeight = i;
            }
        }
        System.out.println(minTime + " " + flatHeight);
    }
}

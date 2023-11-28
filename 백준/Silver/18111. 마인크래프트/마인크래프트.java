import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] height = new int[257];
        int last = n * m - 1;
        int min = Integer.MAX_VALUE;
        int max = 0;
        int minTime = min;
        int flatHeight = 0;

        int k = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                height[input]++;
                max = Math.max(max,input);
                min = Math.min(min,input);
                k++;
            }
        }

        for (int i = min; i <= max; i++) {
            int time = 0;
            int c = b;
            int gap = 0;
            for (int j = min; j <= max; j++) {
                if(j<i){
                    gap = (i-j)*height[j];
                    time+= gap;
                    c -= gap;
                } else{
                    gap = (j-i)*height[j];
                    time+= gap*2;
                    c += gap;
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

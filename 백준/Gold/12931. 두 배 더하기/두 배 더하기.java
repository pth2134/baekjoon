import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] b = new int[n];
        boolean[] zero = new boolean[n];
        int cnt = 0;
        int zeroCnt = 0;
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            if(b[i]==0) {
                zeroCnt++;
                zero[i] = true;
            }
        }
        while(true){
            for (int i = 0; i < n; i++) {
                if(!zero[i]){
                    if(b[i]%2!=0) {
                        b[i]--;
                        cnt++;
                        if(b[i]==0){
                            zero[i] = true;
                            zeroCnt++;
                        }
                    }
                    b[i]/=2;
                }
            }
            if(zeroCnt==n) break;
            cnt++;
        }
        System.out.println(cnt);
    }
}

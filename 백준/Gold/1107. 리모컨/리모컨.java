import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int goal = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        if(m!=0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++) {
                int n = Integer.parseInt(st.nextToken());
                broken[n] = true;
            }
        }

        int result = Math.abs(goal - 100);
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) { 
                    isBreak = true;
                    break;
                }
                
            }
            if(!isBreak) {
                int min = Math.abs(goal - i) + len;
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}
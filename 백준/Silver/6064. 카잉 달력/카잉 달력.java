import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st= new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int day = x;
            int cnt = 0;
            boolean find = false;
            while(cnt<=m){
                while(x>n) {
                    x-=n;
                    cnt++;
                }
                if(x==y) {
                    find = true;
                    break;
                }
                day+=m;
                x+=m;
            }
            if(find)sb.append(day).append("\n");
            else sb.append(-1).append("\n");
        }
        System.out.println(sb);
    }
}
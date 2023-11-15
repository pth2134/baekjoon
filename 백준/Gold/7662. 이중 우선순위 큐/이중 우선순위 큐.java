import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> map = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                long num = Long.parseLong(st.nextToken());
                if(cmd.equals("I")){
                    map.put(num, map.getOrDefault(num,0)+1);
                } else {
                    if(map.size()==0) continue;
                    long key = num==1? map.lastKey() : map.firstKey();
                    int val = map.get(key);
                    if(val<=1) map.remove(key);
                    else map.put(key,val-1);
                }
            }
            if(map.size()==0) sb.append("EMPTY").append("\n");
            else sb.append(map.lastKey()).append(" ")
                    .append(map.firstKey()).append("\n");
        }
        System.out.println(sb);
    }
}
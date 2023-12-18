import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int take = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());
            pq.add(new Integer[]{take,deadline});
        }
        int last = pq.peek()[1];
        for (int i = 0; i < n; i++) {
            Integer[] poll = pq.poll();
            if(last>=poll[1]) last = poll[1] - poll[0];
            else last-=poll[0];
        }
        if(last >= 0) System.out.println(last);
        else System.out.println(-1);
    }
}
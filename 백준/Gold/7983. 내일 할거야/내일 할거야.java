import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Integer[] hw = {
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            };
            pq.add(hw);
        }
        Integer[] poll = pq.poll();
        int deadLine = poll[1]-poll[0];
        for (int i = 1; i < n; i++) {
            poll = pq.poll();
            deadLine = Math.min(poll[1]-poll[0],deadLine-poll[0]);
        }

        System.out.println(deadLine);

    }

}
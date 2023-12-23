import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0].equals(o2[0])) return o2[1] - o1[1];
            else return o1[0] - o2[0];
        });
        PriorityQueue<Integer> endpq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Integer[]{start, end});
        }

        int start = pq.peek()[0];
        int end = pq.poll()[1];
        endpq.add(end);
        int sum = 0;

        for (int i = 1; i < n; i++) {
            Integer[] poll = pq.poll();
            if (poll[0] <= end + 1) {
                //연속된 경우
                if (endpq.peek() < poll[0]) endpq.poll();
                endpq.add(poll[1]);
                end = Math.max(end, poll[1]);
            } else {
                // 연속되지 않은 경우 코팅지 크기 구하기
                int width = end - start + 1;
                int height = endpq.size();
                sum += width * height;
                endpq.clear();
                //새로 시작
                start = poll[0];
                end = poll[1];
                endpq.add(end);
            }
        }

        int width = end - start + 1;
        int height = endpq.size();
        sum += width * height;

        System.out.println(sum);

    }
}
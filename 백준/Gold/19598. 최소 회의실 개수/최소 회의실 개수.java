import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] meet = new int[n][2];
        PriorityQueue<Integer> start_time = new PriorityQueue<>((o1, o2) -> o2-o1);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meet[i][0] = Integer.parseInt(st.nextToken());
            meet[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meet, (o1, o2) -> {
            if (o2[1] == o1[1]) return o2[0] - o1[0];
            else return o2[1] - o1[1];
        });

        start_time.add(meet[0][0]);
        for (int i = 1; i < n; i++) {
            boolean oneRoom = false;
            int poll = start_time.poll();
            if (meet[i][1] > poll) start_time.add(poll);
            start_time.add(meet[i][0]);
        }
        System.out.println(start_time.size());
    }
}



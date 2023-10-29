import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int limit = m * 2 / 3 + 1;
        int[] visited = new int[Math.max(n+1,2*limit)];

        pq.add(new Integer[]{n,1});
        visited[n] = 1;
        while (!pq.isEmpty()) {
            Integer[] poll = pq.poll();
            pqPut(m, pq, visited,poll[0],poll[1],limit);
        }
        System.out.println(visited[m]-1);
    }

    private static void pqPut(int m, PriorityQueue<Integer[]> pq, int[] visited,int now,int cnt, int limit) {
        int w1 = now - 1;
        int w2 = now + 1;
        int cnt2 = cnt+1;
        if (now < limit && now != 0) {
            int tp = 2 * now;
            if (visited[tp]==0||visited[tp]>cnt) {
                pq.add(new Integer[]{tp, cnt});
                visited[now * 2] = cnt;
            }
        }
        if (w1 >= 0 && (visited[w1]==0 ||visited[w1] > cnt2)) {
            pq.add(new Integer[]{w1, cnt2});
            visited[w1] = cnt2;
        }
        if (w2 <= m && (visited[w2]==0 ||visited[w2] > cnt2)) {
            pq.add(new Integer[]{w2, cnt2});
            visited[w2] = cnt2;
        }
    }
}
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        StringBuilder sb = new StringBuilder();

        int V = reader.nextInt();
        int e = reader.nextInt();
        int k = reader.nextInt();

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            int w = reader.nextInt();
            graph.get(u).add(new int[]{v, w});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            long g = o1[1] - o2[1];
            if (g < 0) return -1;
            if (g > 0) return 1;
            return 0;
        });

        long[] visited = new long[V + 1];

        for (int i = 1; i <= V; i++) visited[i] = -1;

        visited[k] = 0;
        pq.add(new long[]{k, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long c = cur[1];
            List<int[]> neighbours = graph.get(u);
            for (int[] neighbour : neighbours) {
                int v = neighbour[0];
                long w = c + neighbour[1];
                if (visited[v] == -1 || visited[v] > w) {
                    visited[v] = w;
                    pq.add(new long[]{v, w});
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (visited[i] == -1) {
                sb.append("INF\n");
                continue;
            }
            sb.append(visited[i]).append('\n');
        }

        System.out.println(sb);
    }

    static class Reader {
        final int SIZE = 1 << 15;
        byte[] buffer = new byte[SIZE];
        int index, size;

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        int nextInt() throws IOException {
            int n = 0;
            byte c;
            while ((c = read()) <= 32) ;
            boolean neg = c == '-';
            if (neg) c = read();
            do n = (n << 3) + (n << 1) + (c & 15); while (isNumber(c = read()));
            return neg ? -n : n;
        }

        byte read() throws IOException {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0) buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}
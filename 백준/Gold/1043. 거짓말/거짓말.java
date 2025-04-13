import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int m = reader.nextInt();
        int knows = reader.nextInt();

        Queue<Integer>[] members = new Queue[n + 1];
        Queue<Integer>[] parties = new Queue[m + 1];
        for (int i = 1; i <= n; i++) members[i] = new LinkedList<Integer>();
        for (int i = 1; i <= m; i++) parties[i] = new LinkedList<Integer>();

        Queue<Integer> queue = new LinkedList<>();
        boolean[] tell = new boolean[m + 1];

        for (int i = 0; i < knows; i++) {
            queue.add(reader.nextInt());
        }

        for (int i = 1; i <= m; i++) {
            int k = reader.nextInt();
            for (int j = 0; j < k; j++) {
                int member = reader.nextInt();
                parties[i].add(member);
                members[member].add(i);
            }
        }

        while (!queue.isEmpty()) {
            int p = queue.poll();
            while (!members[p].isEmpty()) {
                int party = members[p].poll();
                if(!tell[party]) {
                    tell[party] = true;
                    m--;
                    while (!parties[party].isEmpty()) {
                        int pm = parties[party].poll();
                        if(pm == p) continue;
                        queue.add(pm);
                    }
                }
            }
        }

        System.out.println(m);
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
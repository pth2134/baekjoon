import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Queue<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tree.put(i, new LinkedList<>());
        }

        int start = -1;
        for (int i = 0; i < n; i++) {
            int from = Integer.parseInt(st.nextToken());
            if (from == -1) start = i;
            else tree.get(from).add(i);
        }

        int cut = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        if (start != cut) que.add(start);
        int cnt = 0;

        while (!que.isEmpty()) {
            int poll = que.poll();
            Queue<Integer> q = tree.get(poll);
            int size = q.size();
            if (size == 0) cnt++;
            for (int i = 0; i < size; i++) {
                int p = q.poll();
                if (p != cut) {
                    que.add(p);
                } else {
                    if(size-1==0) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
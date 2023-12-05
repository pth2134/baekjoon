import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Queue<Integer>> list = new ArrayList<>();
    static boolean[] chain;
    static int cnt = 0;

    static void dfs(int x) {
        int size = list.get(x).size();
        for (int i = 0; i < size; i++) {
            int poll = list.get(x).poll();
            if (!chain[poll]) {
                chain[poll] = true;
                dfs(poll);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        chain = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for (int i = 1; i <= n; i++) {
            if (!chain[i]) {
                chain[i] = true;
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
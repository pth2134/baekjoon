import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num;
            switch (cmd) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) set.remove(num);
                    break;
                case "check":
                    if (set.contains(Integer.parseInt(st.nextToken()))) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                case "all":
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}
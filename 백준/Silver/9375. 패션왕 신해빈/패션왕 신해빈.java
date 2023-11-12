import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, HashSet<String>> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                if(!map.containsKey(type)) {
                    map.put(type,new HashSet<>());
                }
                map.get(type).add(name);
            }
            long mult = 1;
            for (String key : map.keySet()){
                mult*= map.get(key).size()+1;
            }
            sb.append(mult-1).append("\n");
        }
        System.out.println(sb);
    }
}

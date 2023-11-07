import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] load = new int[e][3];
        HashMap<Integer, HashSet<Integer>> unionMap = new HashMap<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            load[i] = new int[]{Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken())};
        }
        Arrays.sort(load, (o1, o2) -> o1[2] - o2[2]);
        int weight = 0;
        for (int i = 0; i < e; i++) {
            Integer from = load[i][0];
            Integer to = load[i][1];
            boolean a = unionMap.containsKey(from);
            boolean b = unionMap.containsKey(to);
            if (!a && !b) {
                unionMap.put(from, new HashSet<>(Arrays.asList(from,to)));
                unionMap.put(to, unionMap.get(from));
            } else if (!a) {
                unionMap.get(to).add(from);
                unionMap.put(from, unionMap.get(to));
            } else if (!b) {
                unionMap.get(from).add(to);
                unionMap.put(to, unionMap.get(from));
            } else if (unionMap.get(from) != unionMap.get(to)) {
                HashSet<Integer> mergeSet = unionMap.get(from);
                mergeSet.addAll(unionMap.get(to));
                for (Integer j : unionMap.get(to)) {
                    if(j.equals(to)) continue;
                    unionMap.replace(j, mergeSet);
                }
                unionMap.replace(to, mergeSet);
            } else {
                continue;
            }
            weight+=load[i][2];
        }
        System.out.println(weight);
    }
}
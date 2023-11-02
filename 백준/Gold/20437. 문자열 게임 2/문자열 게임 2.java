import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 97; i <= 122 ; i++) {
            map.put(i,new LinkedList<>());
        }
        for(int i = 0; i<t; i++){
            for (int j = 97; j <= 122 ; j++) {
                map.get(j).clear();
            }
            String w = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int min = 10001;
            int max = -1;
            for (int j = 0; j < w.length(); j++) {
                int input = w.charAt(j);
                Queue<Integer> q= map.get(input);
                q.add(j);
                if(q.size()==n){
                    int front = q.poll();
                    int dis = j-front+1;
                    min = Math.min(dis,min);
                    max = Math.max(dis,max);
                }
            }
            if(max==-1){
                sb.append(-1).append("\n");
            } else {
                sb.append(min+" "+max+"\n");
            }
        }
        System.out.println(sb);
    }
}
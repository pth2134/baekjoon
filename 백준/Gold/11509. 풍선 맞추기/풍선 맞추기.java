import java.io.*;
import java.util.*;


public class Main {
    static HashMap<Integer,Integer> arrow;

    public static void shot(Integer key){
        if(arrow.containsKey(key)){
            int value = arrow.get(key);
            if(value>1) arrow.replace(key,value-1);
            else arrow.remove(key);
            down(key);
        } else down(key);
    }

    public static void down(Integer key){
        int down = key-1;
        if(arrow.containsKey(down)) arrow.replace(down,arrow.get(down)+1);
        else arrow.put(down,1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arrow = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            shot(height);
        }
        int sum = 0;
        for (Integer i : arrow.values()) {
            sum+= i;
        }
        System.out.println(sum);
    }
}
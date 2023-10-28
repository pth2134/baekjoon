import java.io.*;
import java.util.*;

class Main {
    static char[] str;
    static int[] pair;
    static ArrayList<Integer> pair_place;
    static HashSet<String> set = new HashSet<>();
    static int last;

    public static void track(int r){
        if(r==last) {
            set.add(String.valueOf(str).replaceAll(" ",""));
            return;
        }
        int left = pair_place.get(r);
        int right = pair[left];
        str[left] = str[right] = ' ';
        track(r+1);
        str[left] = '('; str[right] = ')';
        track(r+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s =br.readLine();
        str = s.toCharArray();
        Stack<Integer> left = new Stack<>();
        StringBuilder sb = new StringBuilder();
        pair = new int[str.length];
        pair_place = new ArrayList<>();
        int stack = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                stack++;
                left.push(i);
                pair_place.add(i);
            }
            else if (str[i] == ')'){
                stack--;
                pair[left.pop()] = i;
            }
        }
        last = pair_place.size();
        track(0);
        set.remove(s);
        ArrayList<String> list = new ArrayList<>(set);;
        Collections.sort(list);
        for (String i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}



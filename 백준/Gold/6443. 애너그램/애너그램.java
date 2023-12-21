import java.io.*;
import java.util.*;

public class Main {
    static String str;
    static int length;
    static int[] alp;
    static int size;
    static ArrayList<Integer> list;
    static char[] e;
    static ArrayList<String> result;

    public static void gram(int list_dept) {
        if(list_dept==size) {
            result.add(new String(e));
            return;
        }
        int n = list.get(list_dept);
        int cnt = alp[n];
        char c = (char) (n + 97);
        casees(c,-1,cnt,0,list_dept);
    }

    public static void casees(char c, int j, int cnt, int case_dept, int list_dept) {
        if(case_dept==cnt) {
            gram(list_dept+1);
            return;
        }
        for (int i = j + 1; i <= length - cnt + case_dept; i++) {
            if(e[i]<'a') {
                e[i] = c;
                casees(c,i,cnt,case_dept+1, list_dept);
                e[i] = '`';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            str = br.readLine();
            length = str.length();
            alp = new int[26];
            list = new ArrayList<>();
            e = new char[length];
            for (int j = 0; j < length; j++) {
                int idx = str.charAt(j) - 97;
                if (alp[idx]++ == 0) list.add(idx);
            }
            size = list.size();
            result = new ArrayList<>();
            gram(0);
            Collections.sort(result);

            for(String s : result){
                sb.append(s).append("\n");
            }
        }
        System.out.println(sb);
    }
}

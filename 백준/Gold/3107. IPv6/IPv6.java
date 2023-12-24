import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, ":");
        int size = st.countTokens();
        String[] result = new String[8];
        if (size < 8) {
            int j = fill(str,result,st,size);
            while(st.hasMoreTokens()){
                result[j++] = st.nextToken();
            }
        } else {
            for (int i = 0; i < 8; i++) {
                result[i] = st.nextToken();
            }
        }

        for (int i = 0; i < 8; i++) {
            int length = result[i].length();
            if (length < 4) {
                for (int k = 0; k < 4-length; k++) {
                    sb.append('0');
                }
            }
            sb.append(result[i]).append(':');
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb);
    }

    public static int fill(String str, String[] result, StringTokenizer st, int size){
        char pre = str.charAt(0);
        int j = 0;
        for (int i = 1; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == ':') {
                if (now != pre) result[j++] = st.nextToken();
                else {
                    int n = 8 - size;
                    for (int k = 0; k < n; k++) {
                        result[j++] = "0000";
                    }
                    return j;
                }
            }
            pre = now;
        }
        return j;
    }
}
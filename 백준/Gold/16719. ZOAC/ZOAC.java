import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String str;
    static int length;
    static char[] result;

    public static int setRange(int start, int last){
        while(start<last){
            int min = 200;
            int min_idx = 0;
            for (int i = start; i < last; i++) {
                if(min>str.charAt(i)){
                    min = str.charAt(i);
                    min_idx = i;
                }
            }
            result[min_idx] = str.charAt(min_idx);
            for (int i = 0; i < length; i++) {
                if(result[i]!='\u0000') sb.append(result[i]);
            }
            sb.append("\n");
            last = setRange(min_idx+1,last);
        }
        return start-1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        length = str.length();
        result = new char[length];

        setRange(0,length);

        System.out.println(sb);
    }

}
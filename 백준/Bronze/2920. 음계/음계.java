import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pre = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(st.nextToken());
        int gap = input - pre;
        pre = input;
        for (int i = 2; i < 8; i++) {
            input = Integer.parseInt(st.nextToken());
            if(input - pre != gap) {
                System.out.println("mixed");
                return;
            }
            pre = input;
        }
        if(gap==1) System.out.println("ascending");
        else System.out.println("descending");
    }
}
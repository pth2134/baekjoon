import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int days = 0;
        for (int i = 1; i < x; i++) {
            days += month[i];
        }
        days += y - 1;
        System.out.println(week[days % 7]);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    static String str;
    static int length;
    static int idx = 0;
    static boolean enough_1 = false;
    static boolean marine = false;

    static void search(int idx) {
        if (idx == str.length()) {
            marine = true;
            return;
        }
        if (enough_1) {
            enough_1 = false;
            boolean idx1 = str.charAt(idx) == '0';
            boolean idx2 = str.charAt(idx + 1) == '0';
            if (idx1 && idx2) search_1001(idx); //00이면
            else if (idx1 && !idx2) search(idx + 2); //01패스
        } else {
            boolean idx1 = str.charAt(idx) == '0';
            boolean idx2 = str.charAt(idx + 1) == '0';
            if (idx1 && !idx2) search(idx + 2);//01이면
            else if (!idx1) search_1001(idx + 1);
        }
    }

    static void search_1001(int idx) {
        //1이 두개 이상으로 끝나면 enough_1 = true;
        int zero = 0;
        int one = 0;
        while (idx < length && str.charAt(idx) == '0') {
            idx++;
            zero++;
        }
        if (zero <= 1) return;
        while (idx < length && str.charAt(idx) == '1') {
            idx++;
            one++;
        }
        if (one > 0) {
            if (one >= 2) enough_1 = true;
        } else {
            return;
        }
        search(idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String correct = "SUBMARINE";
        String wrong = "NOISE";

        str = br.readLine();
        length = str.length();
        search(0);
        if(marine) System.out.println(correct);
        else System.out.println(wrong);
    }
}
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int o_cnt = 0;
        int p_cnt = 0;
        boolean o = str.charAt(1)=='O';
        for (int j = 2; j < str.length(); j++) {
            if (str.charAt(j) == 'I') {
                if (str.charAt(j - 2) == 'I' && o) {
                    if (++o_cnt >= n) p_cnt++;
                } else {
                    o_cnt = 0;
                }
                o = false;
            } else {
                if (o) o_cnt = 0;
                o = true;
            }
        }
        System.out.println(p_cnt);
    }
}
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int oCnt = 0;
            int score = 0;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='O'){
                    oCnt++;
                    score+=oCnt;
                } else {
                    oCnt = 0;
                }
            }
            sb.append(score).append("\n");
        }
        System.out.println(sb);
    }
}
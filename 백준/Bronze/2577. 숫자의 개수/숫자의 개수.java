import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine())
                * Integer.parseInt(br.readLine())
                * Integer.parseInt(br.readLine());
        int[] c = new int[10];
        while(a>0){
            c[a%10]++;
            a/=10;
        }
        for (int i = 0; i < 10; i++) {
            sb.append(c[i]).append("\n");
        }
        System.out.println(sb);
    }
}
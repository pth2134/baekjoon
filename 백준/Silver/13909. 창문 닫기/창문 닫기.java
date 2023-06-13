import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long n = Long.parseLong(br.readLine());
        int window = (int)Math.sqrt(n); //n보다 작은 제곱수의 갯수(제곱수만 약수가 홀수개)
        
        bw.write(window + "");
        bw.flush();
        bw.close();
    }
}
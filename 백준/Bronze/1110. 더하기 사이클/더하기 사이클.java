import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int n2 = (n/10+n%10)%10+(n%10)*10;
        int cnt = 1;
        while(n!=n2){
            n2 = (n2/10+n2%10)%10+(n2%10)*10;
            cnt++;
        }
        System.out.println(cnt);
    }
}

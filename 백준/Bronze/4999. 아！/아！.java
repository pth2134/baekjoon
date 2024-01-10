import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String jh = br.readLine();
        String doctor = br.readLine();
        if(jh.contains(doctor)) System.out.println("go");
        else System.out.println("no");
    }

}
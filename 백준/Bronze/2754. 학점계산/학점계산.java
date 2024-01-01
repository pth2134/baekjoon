import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = br.read();
        int p = br.read();
        double score = 'A'+ 4 - a;
        if(p=='+') score+=0.3;
        else if (p=='-') score-=0.3;
        if(score>0) System.out.println(score);
        else System.out.println(0.0);
    }

}
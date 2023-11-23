import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==0) {
            System.out.println(0);
            return;
        }
        int[] dif = new int[n];
        for (int i = 0; i < n; i++) {
            dif[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(dif);
        int cut = (n*15+50)/100;
        int n_cut = n-2*cut;

        int sum = 0;
        for (int i = cut; i < cut+n_cut; i++) {
            sum+=dif[i];
        }
        int avg = (sum+n_cut/2)/n_cut;
        System.out.println(avg);
    }
}
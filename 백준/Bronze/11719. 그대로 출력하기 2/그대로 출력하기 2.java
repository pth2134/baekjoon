import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        try{
            while(true){
                input = br.readLine();
                if(input.equals("")) sb.append("\n");
                else sb.append(input).append("\n");
            }
        }catch (NullPointerException npe){
            System.out.println(sb);
        }
    }
}
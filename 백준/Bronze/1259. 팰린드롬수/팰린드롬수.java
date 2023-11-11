import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "0";
        while (!(input = br.readLine()).equals("0")){
            boolean pel = true;
            int start = -1;
            int last = input.length();
            while(++start<--last){
                if(input.charAt(start)!=input.charAt(last)){
                    pel =false;
                    break;
                }

            }
            if(pel) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.println(sb);
    }
}

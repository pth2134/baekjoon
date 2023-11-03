import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    dq.addLast(x);
                    break;
                case "pop":
                    if(dq.isEmpty()) sb.append(-1+"\n");
                    else sb.append(dq.pollFirst()+"\n");
                    break;
                case "size":
                    sb.append(dq.size()+"\n");
                    break;
                case "empty":
                    if(dq.isEmpty()) sb.append(1+"\n");
                    else sb.append(0+"\n");
                    break;
                case "front":
                    if(dq.isEmpty()) sb.append(-1+"\n");
                    else sb.append(dq.peekFirst()+"\n");
                    break;
                case "back":
                    if(dq.isEmpty()) sb.append(-1+"\n");
                    else sb.append(dq.peekLast()+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
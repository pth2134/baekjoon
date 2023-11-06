import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            list.add(input);
        }
        int s = Integer.parseInt(br.readLine());

        while(s>0&&!list.isEmpty()){
            int min = Math.min(s+1,list.size());
            int maxIdx = 0;
            int max = 0;
            for (int i = 0; i < min; i++) {
                int get = list.get(i);
                if(get>max){
                    max = get;
                    maxIdx = i;
                }
            }
            list.remove(maxIdx);
            sorted.add(max);
            s-=maxIdx;
        }

        int size1 = sorted.size();
        int size2 = list.size();
        for (int i = 0; i < size1; i++) {
            sb.append(sorted.get(i)).append(" ");
        }
        for (int i = 0; i < size2; i++) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
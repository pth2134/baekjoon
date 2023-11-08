import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] juery = new int[n][2];
        int[] c = new int[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            juery[i][0] = Integer.parseInt(st.nextToken());
            juery[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(juery, (o1, o2) -> {if(o1[0]==o2[0]) return o2[1]-o1[1];
            return o1[0]-o2[0];
        });//무게 오름차순, 무게가 같으면 가치 내림차순 > 가벼우면서 비싼게 앞에 오게끔
        Arrays.sort(c);
        //가방에 들어갈 수 있는 보석의 가치를 담는 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o2-o1);

        long result = 0;
        int juery_idx = 0;
        for (int i = 0; i < k; i++) {
            //허용무게가 작은 가방부터 담을 수 있는 무게의 보석을 pq에 넣기 때문에
            //나중에 오는 가방들도 pq에 담긴 보석을 담을 수 있다.
            for (;juery_idx < n; juery_idx++) {
                if(juery[juery_idx][0] <= c[i]) pq.add(juery[juery_idx][1]);
                else break;
            }
            if(!pq.isEmpty()) result += pq.poll();
        }
        System.out.println(result);
    }
}
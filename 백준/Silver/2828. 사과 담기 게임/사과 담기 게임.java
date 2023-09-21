import java.io.*;
import java.util.*;
class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(br.readLine());
		int front = 1;
		int back = m;
		int cnt = 0;
		for(int i =0; i<j; i++){
			int apple = Integer.parseInt(br.readLine());
			if(apple > back){
				int move = apple-back;
				cnt+= move;
				back = apple;
				front +=move;
			} else if(apple < front){
				int move = front - apple;
				cnt+= move;
				front = apple;
				back-= move;
			}
		}
		System.out.println(cnt);
	}
 }
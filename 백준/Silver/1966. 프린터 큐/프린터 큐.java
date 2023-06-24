import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int i =0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //1부터
			int m = Integer.parseInt(st.nextToken()); //0부터
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> pre = new ArrayList<>();
			Queue<Printer> que = new LinkedList<>();
			for(int j =1; j<=n; j++) {
				int input = Integer.parseInt(st.nextToken());
				pre.add(input);
				que.add(new Printer(j,input));
			}
			Collections.sort(pre,Collections.reverseOrder());
			int k =0;
			while(true) {
				if(que.peek().pre == pre.get(0)) {
					k++; pre.remove(0);
					if(que.poll().number==m+1) {
						bw.write(k+"\n");
						break;
					}
				}
				else {
					que.add(que.poll());
				}
			}
			
		}
		bw.flush();
	}
}

class Printer{
	int number;
	int pre;
	
	Printer(int n, int pre){
		this.number = n;
		this.pre = pre;
	}
}
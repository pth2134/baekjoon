import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			int len = str.length()-1;
			if(str.charAt(len)=='0') {
				sb.append("NO").append("\n");
				continue;
			}
			boolean y = true;
			Queue<Integer[]> que = new LinkedList<>();
			int cnt = 0;
			for (int j = 0; j <= len; j++) {
				if (str.charAt(j)=='0'){
					cnt++;
				} else {
					if(cnt>0) que.add(new Integer[]{cnt,j-1});
					cnt = 0;
				}
			}
			int size = que.size();
			if(size > 0) {
				Integer[] pre = que.poll();
				if (pre[0]>=2){
					if (pre[1]-pre[0]!=0) {
						sb.append("NO").append("\n");
						continue;
					}
				} else{
					if(pre[1]-1!=-1) {
						sb.append("NO").append("\n");
						continue;
					}
				}
				for (int j = 1; j < size; j++) {
					Integer[] poll = que.poll();
					if (pre[0] >= 2){
						if (poll[0] >=2){
							if (poll[1]-poll[0]-pre[1]<2) {
								y = false;
								break;
							}
						}
					} else {
						if(poll[0] >=2){
							if(poll[1]-poll[0]-pre[1]!=2){
								y = false;
								break;
							}
						} else{
							if(poll[1]-poll[0]-pre[1]!=1){
								y = false;
								break;
							}
						}
					}
					pre = poll;
				}
				if(pre[1]<len-1&&pre[0]==1) {
					y= false;
				}
			}
			else y = false;
			if (y) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}
}
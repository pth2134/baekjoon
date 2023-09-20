import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Queue<Integer> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		char first = str.charAt(0);
		char last = first;
		int cnt = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i)==last) cnt++;
			else{
				que.add(cnt);
				last = str.charAt(i);
				cnt = 1;
			}
		}
		que.add(cnt);
		boolean a = first=='X';
		boolean p = true;
		while(!que.isEmpty()){
			int poll = que.poll();
			if(a){
				a=false;
				int rest = poll%4;
				for (int i = 0; i < poll/4; i++) {
					sb.append("AAAA");
				}
				if(rest==2){
					sb.append("BB");
				} else if(rest!=0){
					p=false;
					break;
				}
			} else{
				a=true;
				for (int i = 0; i < poll; i++) {
					sb.append(".");
				}
			}
		}
		if(p) System.out.println(sb);
		else System.out.println(-1);
	}
 }
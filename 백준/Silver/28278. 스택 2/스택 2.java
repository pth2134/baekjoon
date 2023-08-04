import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			Stack<Integer> s = new Stack<>();
			for(int i =0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int input = Integer.parseInt(st.nextToken());
				switch (input) {
				case 1:
					s.push(Integer.parseInt(st.nextToken()));
					break;
				case 2:
					if(s.empty()) {
						bw.write(-1+"\n");
					} else {
						bw.write(s.pop()+"\n");
					}
					break;
				case 3:
					bw.write(s.size()+"\n");
					break;
				case 4:
					if(s.empty()) {
						bw.write(1+"\n");
					} else {
						bw.write(0+"\n");
					}
					break;
				case 5:
					if(s.empty()) {
						bw.write(-1+"\n");
					} else {
						bw.write(s.peek()+"\n");
					}
					break;
				}
			}
			bw.flush();
		}
 }
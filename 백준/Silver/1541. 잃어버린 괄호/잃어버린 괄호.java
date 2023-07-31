import java.io.*;
import java.util.*;

class Main{

	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			
			String str = br.readLine();
			boolean[] np = new boolean[50];
			int q = 0;
			char s;
			
			for(int i =0; i<str.length(); i++) {
				s = str.charAt(i);
				if(s=='-'||s=='+') {
					if(s=='+') {
						np[q] = true;
					}
					q++;
				}
			}
			
			st = new StringTokenizer(str,"-,+");
			
			int sum = 0;
			int total = Integer.parseInt(st.nextToken());
			int p = 0;
			boolean plus = true;
			while(st.hasMoreTokens()) {
				if(np[p++]) { //+면
					sum+= Integer.parseInt(st.nextToken());
				} else {
					if(plus) {
						total+= sum;
					} else {
						total-= sum;
					}
					plus = false;
					sum = Integer.parseInt(st.nextToken());
				}
			}
			if(plus) {
				total += sum;
			} else {
				total -= sum;
			}
			bw.write(total+"");
			bw.flush();
		}
 }
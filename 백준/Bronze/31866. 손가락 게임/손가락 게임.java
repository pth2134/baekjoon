import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()); // 준성이
		int b = Integer.parseInt(st.nextToken()); // 익준이
		
		if (a == 0) { // 준성이가 묵일때
			if (b == 5) { // 익준이가 빠일때 
				sb.append("<");
			} else if (b == 0) {  // 익준이가 묵일떄
				sb.append("=");
			} else { // 그 외
				sb.append(">");
			}
			
		} else if (a == 2) { // 준성이가 찌일때
			if (b == 0) { // 익준이가 묵일때 
				sb.append("<");
			} else if (b == 2) {  // 익준이가 찌일떄
				sb.append("=");
			} else { // 그 외
				sb.append(">");
			}
			
		} else if (a == 5) { // 준성이가 빠일때
			if (b == 2) { // 익준이가 찌일때 
				sb.append("<");
			} else if (b == 5) {  // 익준이가 빠일떄
				sb.append("=");
			} else { // 그 외
				sb.append(">");
			}
			
		} else { // 그 외
			if (b == 0 || b == 2 || b == 5) { // 익준이가 무효가 아닐때
				sb.append("<");
			} else {
				sb.append("=");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
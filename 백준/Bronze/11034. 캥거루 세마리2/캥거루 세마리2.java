import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String input;
		while((input = br.readLine())!=null&&!input.equals("")){
			st = new StringTokenizer(input);
			int lo = Integer.parseInt(st.nextToken());
			int mid = Integer.parseInt(st.nextToken());
			int hi = Integer.parseInt(st.nextToken());
			int max = Math.max(mid-lo,hi-mid);
			sb.append(max-1).append("\n");
		}
		System.out.println(sb);
	}
}
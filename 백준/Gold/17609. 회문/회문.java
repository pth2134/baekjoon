import java.io.*;

public class Main {
	static String str;
	static int pel(int start, int end, int cnt){
		if(cnt==2) return 2;
		boolean check = true;
		while(start<=end){
			if(str.charAt(start)!=str.charAt(end)) {
				check = false;
				break;
			}
			start++; end--;
		}
		if(!check) {
			return Math.min(pel(start+1,end,cnt+1),pel(start,end-1,cnt+1));
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			sb.append(pel(0,str.length()-1,0)).append("\n");
		}
		System.out.println(sb);
	}
}
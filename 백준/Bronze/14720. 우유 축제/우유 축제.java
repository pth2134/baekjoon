import java.io.*;
import java.util.*;
class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int milk = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if(Integer.parseInt(st.nextToken())==milk){
				milk = (milk+1)%3;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
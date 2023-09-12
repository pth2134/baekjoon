import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int l = 0; l < t; l++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int cnt = 0;
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int r2 = r*r;
				int dx1 = x1-x;
				int dy1 = y1-y;
				int d1 = dx1*dx1+dy1*dy1;
				int dx2 = x2-x;
				int dy2 = y2-y;
				int d2 = dx2*dx2+dy2*dy2;
				if(d1<r2&&d2<r2){
					continue;
				} else if(d1<r2||d2<r2){
					cnt++;
				}
			}

			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
 }
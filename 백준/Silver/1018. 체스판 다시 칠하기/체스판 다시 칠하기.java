import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			char[][] wb = new char[m][n];
			for(int i = 0; i<m; i++) {
				wb[i] = br.readLine().toCharArray();
			}
			
			int yMove = 0;
			int faultMin = 64;
			while(yMove+8 <= m) {
				int xMove =0;
				while(xMove+8 <=n) {
					int cnt = chess(wb, xMove, yMove);	
					if(faultMin > cnt) faultMin = cnt;
				xMove++;
				}
				yMove++;
			}
			bw.write(faultMin+"");
			bw.flush();
			bw.close();
	
		}
		catch (Exception IO){
		}	
	}	
	
	public static int chess(char[][] wb,int xMove,int yMove) {
		int wCnt = 0;
		int bCnt = 0;
		for(int i =yMove; i<yMove+8; i++) {
			for(int j=xMove; j<xMove+8; j++) {
				if((i+j-xMove-yMove)%2==0) {
					if(wb[i][j]=='W') bCnt++;
					else wCnt++;	
				}
				else {
					if(wb[i][j]=='W') {
					wCnt++;
					}
					else bCnt++;
				}
			}
		}
		int cnt = wCnt > bCnt ? bCnt : wCnt;
		return cnt;
	}
}
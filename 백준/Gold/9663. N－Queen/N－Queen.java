import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static int cnt = 0;
	 
	
	public static void queen(int y, int[][] check) {
		//y축 위치를 증가 시키며 한 개씩 퀸을 놓는다.
		if(y==n) {
			//n-1까지 끝내고 n이 입력된다면 cnt++
			cnt++;
		}
		else {
			for(int i =0; i<n; i++) {
				if(check[y][i]==0) {
					signX(y,i,check);
					sign(y,i,check);
					queen(y+1,check);
					unSignX(y,i,check);
					unSign(y,i,check);
				}
			}
		}
	}
	
	public static void signX(int y, int x, int[][] check) {
		int xl = x;
		int xr = x;
		for(int i =y+1; i<n; i++) {
			if(xl>0) check[i][--xl]++;
			if(xr<n-1) check[i][++xr]++;
		}
	}
	
	public static void unSignX(int y, int x, int[][] check) {
		int xl = x;
		int xr = x;
		for(int i =y+1; i<n; i++) {
			if(xl>0) check[i][--xl]--;
			if(xr<n-1) check[i][++xr]--;
		}
	}
	
	public static void sign(int y, int x, int[][] check) {
		for(int i = y+1; i<n; i++) {
			check[i][x]++;
		}
	}
	
	public static void unSign(int y, int x, int[][] check) {
		for(int i = y+1; i<n; i++) {
			check[i][x]--;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		int[][] check = new int[n][n];
		
		int r = n/2;
		for(int i=0; i<=r-1; i++) {
			//반나눠서 x2(좌우 대칭상황) 체스판 가장 윗 라인의 퀸 위치(i,0) >편의상 0을 위라고 생각
				sign(0,i,check);
				signX(0,i,check);
				queen(1,check);
				unSign(0,i,check);
				unSignX(0,i,check);
			
		}
		
		if(n!=1) cnt*=2;
		
		if(n%2 ==1) {
            //n이 홀수일 때, 퀸이 가장 윗칸 가운데에 있을 경우를 따로 더해줌
			sign(0,r,check);
			signX(0,r,check);
			queen(1,check);
			unSign(0,r,check);
			unSignX(0,r,check);	
		}
		
		bw.write(cnt+"");
		bw.flush();
	}
	
}
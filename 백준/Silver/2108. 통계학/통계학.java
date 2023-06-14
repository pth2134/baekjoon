import java.io.*;
import java.util.*;

public class Main {
	public static int round(int sum, int n) {
		int average = sum/n;
		int remain = sum%n;
		if(average>=0) {
			average += remain>n/2? 1:0; //n은 홀수
		}
		else {
			average -= remain<-n/2? 1:0;
		}
		return average;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		try {
			int n = Integer.parseInt(br.readLine());
			int[] number = new int[n];
			int[] index = new int[8001]; //(int)-4000~0 (index)0~4000, (int)1~4000 (index)4001~8000
			int[] countSum = new int[8001];
			int[] sortedNumber = new int[n];
			int sum =0;
			int midleIndex = n/2;
			int maxCnt=0;
			int maxCntNum = 0;
			int range =0;
			for(int i =0; i<n; i++) {
				int input = Integer.parseInt(br.readLine());
				number[i] = input;
				sum+=input;
				int cnt = ++index[input+4000];//index의 0이 input -4000을 가리킨다.
				if(cnt > maxCnt) {
					maxCnt = cnt;
				}
				
			}
			countSum[0] = index[0];
			for(int i =1; i<8001; i++) {
				countSum[i] = countSum[i-1] + index[i];
			}
			for(int i=0; i<n; i++) {
				sortedNumber[--countSum[4000+number[i]]] = number[i];
			}
			int cnt = 2;
			for(int i =0; i<8001; i++) {
				if(index[i]==maxCnt) {
					maxCntNum = i-4000;
					cnt--;
				}
				if(cnt==0) break;
			}
			
			int average = round(sum,n);
			int midle = sortedNumber[midleIndex];
			range = sortedNumber[n-1]-sortedNumber[0];
			bw.write(average+" "+midle+" "+maxCntNum+" "+range);
			bw.flush();
			
		
		
		
		} catch (IOException e) {
			
		}
	}
}
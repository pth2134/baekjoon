import java.io.*;
import java.util.*;

public class Main {
	//2번 나오는 방향 체크 > 반대(1이면 2, 3이면 4)의 길이랑 비교
	//제일 큰 변 2개를 저장(두 변은 붙어있음)
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Queue<Farm> q = new LinkedList<>();
		int max = 0; //방향이 1,2중에 가장 긴 변
		int max2 = 0; //방향이 3,4중에 가장 긴 변
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			q.add(new Farm(dir,len));
			if(dir<=2) {
				max = len>max? len:max;
			} else {
				max2 = len>max2? len:max2;
			}
		}
		
		
		int area = max*max2;
		int area2 = 1;
		
		for (int i = 0; i < 6; i++) { 
			if((q.peek().dir<=2&&q.peek().len==max)||(q.peek().dir>2&&q.peek().len==max2)) { //긴 변2개 다음에 움푹 파인 사각형의 변이 나오는 것을 이용
				q.poll();
				if((q.peek().dir<=2&&q.peek().len==max)||(q.peek().dir>2&&q.peek().len==max2)) {
					q.poll();
				}
				q.poll();
				area2 *= q.poll().len;
				area2 *= q.poll().len;
				break;
			}
			else {
				q.add(q.poll());
			}
		}
		bw.write((area-area2)*n+"");
		bw.flush();
	}
	
}

class Farm{
	int dir;
	int len;
	public Farm(int dir, int len) {
		super();
		this.dir = dir;
		this.len = len;
	}
	
}
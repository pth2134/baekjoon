import java.io.*;
import java.util.*;

class stack{
	int size = 100000;
	int[][] s = new int[100000][2];
	int idx = 0;
	stack(){}
	void add(int h, int i){
		s[idx][0]= h;
		s[idx][1]= i;
		idx++;
	}
	int[] pop(){
		return s[--idx];
	}

	int[] peek(){
		return s[idx-1];
	}

	boolean isEmpty(){
		if(idx>0) return false;
		else return true;
	}

}

class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		stack s = new stack();
		int max = 0;
		for(int i=0; i<n; i++){
			int input = Integer.parseInt(br.readLine());
			if(!s.isEmpty()){
				int h = s.peek()[0];
				int j = s.peek()[1];
				if(h>=input){ //같으면 continue;
					int k = i;// 현재 높이보다 크거나 같은 지점의 시작점 갱신
					while(s.peek()[0]>=input){
						int area = s.peek()[0]*(i-s.peek()[1]);
						k = s.peek()[1];
						max = area > max? area:max;
						s.pop();
						if(s.isEmpty()) break;
					}
					s.add(input, k);
				} else {
					s.add(input,i);
				}
			} else { //stack이 비어있으면 현재값이 가장 작은 h라는 의미
				s.add(input,0);
			}
		}
		while(!s.isEmpty()){
			int area = s.peek()[0]*(n-s.peek()[1]);
			max = area > max? area:max;
			s.pop();
		}

		System.out.println(max);
	}
 }
import java.io.*;

class stack{
	int[][] s = new int[500000][2];
	int idx = 0;
	stack(){}
	void add(int h, int same){
		s[idx][0]= h;
		s[idx][1] = same;
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
		long cnt = 0;
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			int same = 0;
			if(!s.isEmpty()) {
				int[] s_peek = s.peek();
				if(input < s_peek[0]) {
					cnt++;
				}
				else if(input > s_peek[0]){
					boolean check = false;
					while(input > s.peek()[0]) {
						s.pop();
						cnt++;
						if(s.isEmpty()) {
							check = true;
							same = -1;
							break;
						}
					}
					if(!check){
						if(input == s.peek()[0]){
							same = s.peek()[1]+1;
						}
						cnt+=same+1;
					}
				}
				else{
					same = s.peek()[1]+1;
					cnt+= same+1;
				}
			} else{
				same = -1;
			}
			s.add(input,same);
		}


		System.out.println(cnt);
	}
 }
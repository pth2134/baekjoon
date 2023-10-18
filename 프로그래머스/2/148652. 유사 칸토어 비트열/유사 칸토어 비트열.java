class Solution {
	public long solution(int n, long l, long r) {
		long[][] bit = new long[21][2];
		boolean[][] check = new boolean[21][2];
		int m = n;
		bit[n][0] = l;
		bit[n][1] = r;
		while(m>0){
			m--;
			l=(l+4)/5;
			r=(r+4)/5;
			bit[m][0] = l;
			bit[m][1] = r;
		}
		bit[0][0]=bit[0][1]=1;
		check[0][1]=check[0][0]=true;
		long sum = 1;
		for (int i = 1; i <= n; i++) {
			sum*=4;
			if(check[i-1][0]){
				long gap = bit[i][0]-bit[i-1][0]*5+4;
				if(gap!=2) check[i][0] =true;
				if(gap<=1) sum-=gap;
				else if(gap==2) sum-=2;
				else sum-=gap-1;
			}
			if(check[i-1][1]){
				long gap = bit[i-1][1]*5-bit[i][1];
				if(gap!=2) check[i][1] =true;
				if(gap<=1) sum-=gap;
				else if(gap==2) sum-=2;
				else sum-=gap-1;
			}
		}
		long answer = sum;
		return answer;
	}

}
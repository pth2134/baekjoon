class Solution {

	public static int solution(int[] cards) {
		int answer = 0;
		boolean[] visit;
		boolean[] visit2;
		for(int i=0; i<cards.length; i++){
			visit = new boolean[cards.length];
			int sum1 = 0;
			int next = i;
			while(!visit[next]){
				int box = next;
				next=cards[box]-1;
				visit[box]= true;
				sum1++;
			}
			int sum2 = 0;
			for (int j = 0; j < cards.length; j++) {
				if(!visit[j]){
					sum2=0;
					visit2 = new boolean[cards.length];
					next = j;
					while(!visit[next]&&!visit2[next]){
						int box = next;
						next = cards[box]-1;
						visit2[box]= true;
						sum2++;
					}
					answer = Math.max(answer,sum1*sum2);
				}
			}
		}
		return answer;
	}

}
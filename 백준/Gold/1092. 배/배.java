import java.io.*;
import java.util.*;
class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[][] crain = new int[n][2];
		for (int i = 0; i <n ; i++) {
			crain[i][0] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(crain,(o1, o2) -> o1[0]-o2[0]);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] load = new int[m];

		for (int i = 0; i < m; i++) {
			load[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(load);
		int c = 0;
		for (int i = 0; i < m; i++) {
			//들수있는 무게를 약한 크레인부터 채우기
			//(가장 강한 크레인에는 자신만이 들 수 있는 수하물 갯수가 저장됨)
			while(load[i]>crain[c][0]) {
				c++;
				if(c==n) {
					System.out.println(-1);
					return;
				}
			}
			crain[c][1]++;
		}
		int task = 0; //도움없이 옮긴 갯수
		int task_down = 0;// task까지 도움받은 갯수
		int spare = 0; //크레인 여유분
		for (int i = n-1; i >= 0; i--) {
			spare++;
			int rest = crain[i][1]-task+task_down;
			task_down = 0;
			if(rest>0){
				int up= (rest+spare-1)/spare;//task까지 혼자 일하고 남은건 여유크레인이 도와줌
				task_down = rest- up*spare;//여유크레인이 남은작업량보다 많으면 다음 크레인을 도와줌
				task+=up;
			} else{ //나머지가 음수면
				task_down=rest;//이미 앞의 크레인을 도와줬음
			}
		}
		System.out.println(task);
	}
}
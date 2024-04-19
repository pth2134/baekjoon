import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	static int n;
	static char[] pillar = {'A', 'B', 'C', 'D' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		build4(n, 0, 1);
		System.out.println(cnt);
		System.out.println(sb);
	}

	public static void build3(int height, int start, int dest) {
		//start의 맨 아래 있는 원판을 dest로 옮기기 위해 나머지 기둥에 n-1 하노이 탑을 옮기는 메서드 
		if (height > 1) {
			build3(height - 1, start, 3 - start - dest);
			sb.append(pillar[start]).append(' ').append(pillar[dest]).append("\n");
			build3(height - 1, 3 - start - dest, dest);
		} else {
			sb.append(pillar[start]).append(' ').append(pillar[dest]).append("\n");
		}
		cnt++;
	}

	public static void build4(int height, int start, int dest) {
		//n-2까지 하노이 쌓고 바닥에 남은 2개를 옮기는 메서드
		if (height > 2) {
			build3(height - 2, start, dest);
			setBottom(start, 3 - start - dest);
			build4(height - 2, dest, start);
		} else if (height == 2) {
			setBottom(start, dest);
		} else {
			sb.append(pillar[start]).append(' ').append('D').append("\n");
			cnt++;
		}
	}

	public static void setBottom(int start, int dest) {
		sb.append(pillar[start]).append(' ').append(pillar[dest]).append("\n");
		sb.append(pillar[start]).append(' ').append('D').append("\n");
		sb.append(pillar[dest]).append(' ').append('D').append("\n");
		cnt += 3;
	}

}
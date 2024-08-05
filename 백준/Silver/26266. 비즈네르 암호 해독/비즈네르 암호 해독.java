import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String org = br.readLine();
		String code = br.readLine();

		int l = org.length();

		int[] keys = new int[l];

		for (int i = 0; i < l; i++) {
			int c = code.charAt(i) - org.charAt(i);
			keys[i] = c > 0 ? c : c + 26;
		}

		int length = 1; //key의 길이
		int idx = 0; //비교중인 key의 idx

		for (int i = 1; i < l; i++) {
			if (keys[i] != keys[idx]) {
				length = i + 1; //반복이 안된다면 현재 위치까지를 key의 길이로 설정
				while (l % length != 0) { //원문의 길이가 나누어 떨어 질 때까지 key의 길이를 증가
					length++;
					i++;
				}
				idx = 0;
				continue;
			}

			idx = (idx + 1) % length;
		}

		for (int i = 0; i < length; i++) {
			sb.append((char)(keys[i] + 64));
		}

		System.out.println(sb);
	}

}
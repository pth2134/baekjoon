import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] carN = sc.next().toCharArray();
		int ans = 1;
		for (int i = 0; i < carN.length; i++) {
			if (i == 0) { 
            // 첫번째 숫자의 경우의 수
				if (carN[i] == 'c') {
					ans *= 26;
				} else {
					ans *= 10;
				}
			} else {
            //두번째 숫자부터의 경우의 수
				if (carN[i] == carN[i - 1]) {
					if (carN[i] == 'c') {
						ans *= 25;
					} else {
						ans *= 9;
					}
				}
				else {
					if (carN[i] == 'c') {
						ans *= 26;
					} else {
						ans *= 10;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
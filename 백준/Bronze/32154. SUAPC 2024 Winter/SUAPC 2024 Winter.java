import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 사용자로부터 정수 입력 받기

        switch (N) {
            case 1:
                System.out.println(11);
                System.out.println("A B C D E F G H J L M");
                break;
            case 2:
                System.out.println(9);
                System.out.println("A C E F G H I L M");
                break;
            case 3:
                System.out.println(9);
                System.out.println("A C E F G H I L M");
                break;
            case 4:
                System.out.println(9);
                System.out.println("A B C E F G H L M");
                break;
            case 5:
                System.out.println(8);
                System.out.println("A C E F G H L M");
                break;
            case 6:
                System.out.println(8);
                System.out.println("A C E F G H L M");
                break;
            case 7:
                System.out.println(8);
                System.out.println("A C E F G H L M");
                break;
            case 8:
                System.out.println(8);
                System.out.println("A C E F G H L M");
                break;
            case 9:
                System.out.println(8);
                System.out.println("A C E F G H L M");
                break;
            case 10:
                System.out.println(8);
                System.out.println("A B C F G H L M");
                break;
            default:
                System.out.println("지원되지 않는 입력입니다.");
                break;
        }

        scanner.close(); // Scanner 리소스 해제
    }
}
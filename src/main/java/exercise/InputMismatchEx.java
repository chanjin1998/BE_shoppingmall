package exercise;

import java.util.Scanner;

public class InputMismatchEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (scanner.hasNextInt()) {
                int score = scanner.nextInt();
                if (score >= 60)
                    System.out.println("합격");
                else
                    System.out.println("다음에 다시 봐용ㅋ");
            } else if (scanner.hasNext("[qQ]")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
        System.out.println("끝");
        scanner.close();
    }
}

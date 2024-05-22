package exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MbtiThrowsEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("=== MBTI ===");
            System.out.println("1. 나는 밖에서 에너지를 얻는다.");
            System.out.println("2. 나는 이불 속에서 에너지를 얻는다.");
            System.out.println("당신의 선택은?");
            int val = scanner.nextInt();
            checkEorI(val);
            // 1. 나는 밖에서 에너지를 얻는다.
            // 2. 나는 이불 속에서 에너지르 얻는다.
            // 당신의 선택은?(숫자로 입력받기)
            // 1 입력 -> E, 2 입력 -> I
            System.out.println("=== End ===");
        } catch (InputMismatchException e) {
            System.out.println("키보드 입력이 잘못 되었습니다.");
        } finally {
            if (scanner != null)
                System.out.println("scanner close");
                scanner.close();
        }
    }

    public static void checkEorI(int val) {
        if (val == 1)
            System.out.println("E");
        else if (val == 2) {
            System.out.println("I");
        }
    }
}

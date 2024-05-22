package exercise;

import java.util.Scanner;

public class AgeThrowCheckerEx {
    public static void main(String[] args) {
        // num input
        // 당신의 나이는 몇살이네요. 반갑습니다.
        while (true) {
            System.out.println("나이를 입력하세요. 범위는 0살부터 100살입니다.");
            Scanner scanner = new Scanner(System.in);
            try {
                int age = scanner.nextInt();
                if (age == -1)
                    break;
                else if (age <= -2 || age > 100)
                    throw new IntegerRangeEx("0살부터 100살까지만 입력하세요.");
                    // -2보다 작고 100보다 크면 에러
                else
                    System.out.println("당신의 나이는 " + age + "이네요. 반갑습니다.");
            } catch (IntegerRangeEx e) {
                e.getMessage();
            }
            finally{
                System.out.println("scanner close");
//                scanner.close();
            }

        }
    }
}

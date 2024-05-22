package com.example.shoppingmall;

import java.util.*;

public class NumberBaseballGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] answer = new int[3];
        for (int i = 0; i < 3; i++) {
            answer[i] = random.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (answer[i] == answer[j]) {
                    i--;
                    break;
                }
            }
        }

        // 게임 시작
        System.out.println("숫자야구 게임 시작!");
        System.out.println("3자리의 숫자를 공백 없이 입력해주세요!");

        int attempts = 0; // 시도 횟수

        while (attempts < 10) { // 최대 10번까지 시도 가능

            System.out.println("시도 횟수: "+attempts+"회");
            String input = scanner.nextLine();

            try {
                // 세 자리 숫자인지 확인
                int[] guess = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
                if (guess.length != 3) {
                    throw new NumberFormatException();
                }

                // 스트라이크, 볼, 아웃 판정
                int strike = 0, ball = 0, out = 0;
                for (int i = 0; i < 3; i++) {
                    if (guess[i] == answer[i]) {
                        strike++;
                    } else if (contains(answer, guess[i])) {
                        ball++;
                    } else {
                        out++;
                    }
                }

                // 결과 출력
                if (strike == 3) {
                    System.out.println("정답!");
                    break;
                } else if (strike == 0 && ball == 0) {
                    System.out.println("3 Out");
                } else {
                    System.out.println(strike + "S " + ball + "B " + out + "Out");
                }
            } catch (NumberFormatException e) {
                System.out.println("세 자리 숫자를 입력하세요.");
                continue; // 예외처리한 값을 시도 횟수에 포함하지 않음.
            }
            attempts++;

        }

        if (attempts == 10) {
            System.out.println("시도 횟수를 초과! 정답은 " + Arrays.toString(answer) + "입니다.");
        }

        scanner.close();
    }

    // 배열 안에 특정 숫자가 포함되어 있는지 확인하는 메소드
    private static boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
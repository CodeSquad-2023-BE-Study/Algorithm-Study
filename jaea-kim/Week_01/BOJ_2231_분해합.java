package Week_01;

import java.util.Scanner;

public class BOJ_2231_분해합 {
    public static void main(String[] args) {
        /*
        자연수 123 의 분해합 - 123 + 1 + 2 + 3
        123은 129의 생성자
        생성자 구하기
        ! 생성자 출력 없으면 0
         */
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();// 1 ~ 1,000,000

        //input = 생성자 + 자리수의 합
        //1. 자리수 확인
        int digit = 1;
        int a = input;
        while ((a / 10) != 0) {
            digit++;
            a /= 10;
        }
        //2. 자리수 합 최소 ~ 최대
        int min = 1 * digit;
        int max = 9 * digit;
        int answer = 0;
        //3. 반복?
        for (int i = max; i >= min; i--) {
            int num = input - i;
            int testNum = num;
            int c = testNum;
            for (int j = 0; j < digit; j++) {
                testNum += num % 10;
                num /= 10;
            }
            if (testNum == input) {
                answer = c;
                break;
            }
        }
        System.out.println(answer);
    }

}

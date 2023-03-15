package week_01;

import java.util.Scanner;

/*
 * 문제 풀이 방법:
 * 1. 1부터 N까지 분해합 구하기
 * 2. 분해합이 N과 같다면 해당 값을 변수에 저장(바로 출력하지 않는 이유는 생성자가 없는 경우에 0을 출력해야 하기 때문)
 * 3. 이후 변수 값 출력
 */

public class BOJ_2231_분해합 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int result = 0;

        for (int i = 1; i <= N; i++) {
            int number = i;
            int sum = 0;

            // 분해합 구하기
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            // 분해합과 N이 같은지 비교
            if ((sum + i) == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}

package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2417_정수_제곱근 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        long n = Long.parseLong(br.readLine());

        // 제곱근
        long sqrt = (long) Math.sqrt(n);

        // 제곱근의 제곱이 n 보다 작으면 +1, 아니면 그대로 출력
        if (Math.pow(sqrt, 2) < n) {
            System.out.println(sqrt + 1);
        } else {
            System.out.println(sqrt);
        }
    }
}

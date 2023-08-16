package HyowonSin.Week_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1065_한수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        if (N < 100) {
            System.out.println(N);
        } else {
            count = 99;

            for (int i = 100; i <= N; i++) {
                int first = i / 100;
                int second = (i / 10) % 10;
                int third = i % 10;

                if (first - second == second - third) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

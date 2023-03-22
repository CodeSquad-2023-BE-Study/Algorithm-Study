package week_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1940_주몽 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] number = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int pointer1 = 0;
        int pointer2 = 1;
        int count = 0;

        while (true) {

            if (number[pointer1] + number[pointer2] == m) {
                count++;
                pointer1++;
                pointer2 = pointer1 + 1;
            } else {
                pointer2++;
            }
            if (pointer2 == number.length) {
                pointer1++;
                pointer2 = pointer1 + 1;
            }
            if (pointer1 == number.length - 1) {
                break;
            }
        }

        System.out.println(count);
    }
}

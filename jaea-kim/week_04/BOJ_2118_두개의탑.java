package week_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2118_두개의탑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distance = new int[N];
        int circleDistance = 0;

        for (int i = 0; i < N; i++) {
            distance[i] = Integer.parseInt(br.readLine());
            circleDistance += distance[i];
        }

        int start = 0;
        int result = 0;

        loop:
        while (start < N) {
            int end = start + 1;
            while (end < N) {
                int sum1 = 0;
                for (int i = start; i < end; i++) { //시계방향
                    sum1 += distance[i];
                }
                if (sum1 == (circleDistance - sum1)) {
                    result = sum1;
                    break loop;
                }
                int sum2 = circleDistance - sum1;
                int sum = Math.min(sum1, sum2);
                if (result < sum) {
                    result = sum;
                }
                if (sum1 > sum2) {
                    break;
                }

                end++;
            }
            start++;
        }
        System.out.println(result);
    }
}

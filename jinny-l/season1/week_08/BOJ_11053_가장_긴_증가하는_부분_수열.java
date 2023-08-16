package season1.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_가장_긴_증가하는_부분_수열 {

    private static int[] sequence;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: 수열 길이
        int length = Integer.parseInt(br.readLine());

        // 배열 초기화
        sequence = new int[length];
        dp = new int[length];

        // 입력: 수열
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < length; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        // 출력
        System.out.println(lis());
    }

    private static int lis() {
        int max = 0;

        for (int i = 0; i < sequence.length; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

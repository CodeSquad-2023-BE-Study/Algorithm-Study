package week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] dp = new int[N + 1];
            dp[0] = 1;
            dp[1] = 1;
            if (N >= 2) {
                dp[2] = 2;
            }
            if (N >= 3) {
                dp[3] = 4;
            }
            if (N >= 4) {
                for (int j = 4; j <= N; j++) {
                    dp[j] += dp[j - 1];
                    dp[j] += dp[j - 2];
                    dp[j] += dp[j - 3];
                }
            }
            System.out.println(dp[N]);
        }
    }
}

package week_08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
    /*
    출력 : 정수를 1,2,3 의 합으로 나타내는 경우의 수
    1을 나타내는 경우의 수 - 1
    2를 나타내는 경우의 수 - 2
    3를 나타내는 경우의 수 - 4
    N을 +1, +2, +3 이 될 때로 나누어서 연산
     */
    static int[] dp = new int[11];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] targetCase = new int[T];
        for (int i = 0; i < T; i++) {
            targetCase[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int target : targetCase) {
            if (target < 4) {
                System.out.println(dp[target]);
            }  else {
                System.out.println(dp(target));
            }
        }
    }

    public static int dp(int target) {
        if (dp[target] == 0) {
            return dp(target - 1) + dp(target - 2) + dp(target - 3);
        } else {
            return dp[target];
        }
    }

}

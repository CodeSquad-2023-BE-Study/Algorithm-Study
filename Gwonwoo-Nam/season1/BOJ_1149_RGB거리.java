import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            rgb[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
        }

        System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));

    }
}

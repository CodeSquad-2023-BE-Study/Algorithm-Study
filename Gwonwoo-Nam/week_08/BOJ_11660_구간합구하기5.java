import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[n+2][n+2];
        dp[1][1] = arr[0][0];

        for (int i=2; i<=n; i++) {
            dp[i][1] = dp[i-1][1] + arr[i-1][0];
        }
        for (int j=2; j<=n; j++) {
            dp[1][j] = dp[1][j-1] + arr[0][j-1];
        }
        for (int i=2; i<=n; i++) {
            for (int j=2; j<=n ; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + arr[i-1][j-1];
            }
        }
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        int[] loc;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            loc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            x1 = loc[0];
            y1 = loc[1];
            x2 = loc[2];
            y2 = loc[3];

            ans = dp[x2][y2] + dp[x1 - 1][y1 -1] - dp[x2][y1-1] - dp[x1-1][y2];
            System.out.println(ans);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                //보석 무게가 현재 가방의 허용가능 무게를 초과하면
                if (arr[i-1][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                //보석 무게가 초과하지 않으면
                else {
                    //현재 보석 무게만큼을 비워주고 현재 보석의 가치를 더한 것 vs 기존 최대 값
                    dp[i][j] = Math.max(dp[i-1][j - arr[i-1][0]] + arr[i-1][1], dp[i-1][j]);
                }
            }
        }

        int ans = 0;

        ans = dp[n][k];

        System.out.println(ans);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[1001];


        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[i] > arr[j] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int highest = 0;
        for (int i = 0; i < arr.length; i++) {
            highest = Math.max(highest, dp[i]);
        }

        System.out.println(highest);
    }
}

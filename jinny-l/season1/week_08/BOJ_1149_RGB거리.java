package season1.week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: 집의 수
        int count = Integer.parseInt(br.readLine());

        // 배열 초기화
        int[][] prices = new int[count][3];
        int[][] dp = new int[count][3];

        // 입력: 비용
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                prices[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 구하기
        for (int i = 1; i < count; i++) {
            prices[i][RED] += Math.min(prices[i - 1][GREEN], prices[i - 1][BLUE]);
            prices[i][GREEN] += Math.min(prices[i - 1][RED], prices[i - 1][BLUE]);
            prices[i][BLUE] += Math.min(prices[i - 1][GREEN], prices[i - 1][RED]);
        }

        // 최소값 출력
        System.out.println(Math.min(
                Math.min(prices[count - 1][RED], prices[count - 1][GREEN]), prices[count - 1][BLUE]
        ));
    }
}

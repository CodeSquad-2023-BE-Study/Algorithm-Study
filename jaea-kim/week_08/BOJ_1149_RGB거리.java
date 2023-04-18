package week_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
    /*
    * 고민 : 현재 내 값의 최소값을 더한다고 다음 번에 최솟값 보장 없음 -> 뒤에서 앞으로 생각
    1번째 집은 R,G,B 3가지로 시작 -> 마지막 집이 R,G,B를 선택할 수 있다고 반대로 생각하기
    n번째 집은 내가 칠할 색 제외 중 더한 것의 최솟값 + 나의 값
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] price = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] result = new int[N][3]; //R로 시작, G로 시작, B로 시작

        result[0][0] = price[0][0]; //1번째 집 R 색칠
        result[0][1] = price[0][1];
        result[0][2] = price[0][2];

        for (int i = 1; i < N; i++) {
            result[i][0] = Math.min(result[i -1][1], result[i - 1][2]) + price[i][0];
            result[i][1] = Math.min(result[i - 1][0], result[i - 1][2]) + price[i][1];
            result[i][2] = Math.min(result[i - 1][0], result[i - 1][1]) + price[i][2];
        }

        int a = Math.min(result[N - 1][0], result[N -1][1]);
        System.out.println(Math.min(a, result[N -1][2]));
    }
}

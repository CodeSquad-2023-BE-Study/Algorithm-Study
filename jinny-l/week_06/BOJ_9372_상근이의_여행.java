package week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 최소 신장 트리의 성질:
 * 간선 개수 = 정점 개수 - 1
 */
public class BOJ_9372_상근이의_여행 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력: 테스트 케이스 수
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) { // 테케만큼 반복
            // 입력: 국가의 수(== 정점 개수), 비행기의 종류
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int countryAmount = Integer.parseInt(st.nextToken());
            int airplaneTypeAmount = Integer.parseInt(st.nextToken());

            // 입력: 정점
            for (int j = 0; j < airplaneTypeAmount; j++) {
                br.readLine(); // 사용되지 않는 값이라 입력만 받음
            }

            // 결과: 정점 개수 - 1
            sb.append(countryAmount - 1)
                    .append("\n");
        }

        // 출력
        System.out.println(sb);
    }
}

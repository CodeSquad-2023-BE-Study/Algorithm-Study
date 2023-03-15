package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N 입력 및 정렬
        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);

        // M 입력
        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            if (Arrays.binarySearch(arrN, arrM[i]) >= 0) { // 값이 있을 때
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int value : result) {
            sb.append(value)
                    .append("\n");
        }
        System.out.print(sb);
    }
}

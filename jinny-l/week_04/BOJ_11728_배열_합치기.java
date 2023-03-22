package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11728_배열_합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // A, B 입력받기
        st = new StringTokenizer(br.readLine(), " ");
        int[] AB = new int[N + M];
        for (int i = 0; i < N; i++) {
            AB[i] = (Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            AB[N + i] = (Integer.parseInt(st.nextToken()));
        }
        // 정렬
        Arrays.sort(AB);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int number : AB) {
            sb.append(number).append(" ");
        }
        System.out.print(sb);
    }
}

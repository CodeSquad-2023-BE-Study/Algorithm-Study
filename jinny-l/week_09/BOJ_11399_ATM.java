package week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수 입력
        int N = Integer.parseInt(br.readLine());

        // 인출 시간 입력
        int[] times = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(times);

        // 결과: 누적합 계산
        int sum = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            sum += times[i];
            result += sum;
        }
        System.out.println(result);
    }
}

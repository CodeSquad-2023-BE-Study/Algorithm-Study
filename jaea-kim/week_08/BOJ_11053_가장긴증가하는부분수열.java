package week_08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {
    /*
     * 힌트 얻어서 풀었습니다.. -> `LIS`
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] sequence = new int[T];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] length = new int[T];

        for (int i = 0; i < T; i++) {
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                //현재 체크하는 위치의 요소가 더 클 때
                if (sequence[j] < sequence[i]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
        }

        System.out.println(Arrays.stream(length).max().getAsInt());
    }
}

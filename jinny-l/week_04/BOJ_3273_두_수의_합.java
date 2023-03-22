package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두_수의_합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr); // 두 포인터 알고리즘을 위해 정렬

        int x = Integer.parseInt(br.readLine());

        // 두 포인터 알고리즘
        int count = 0;
        int min = 0;
        int max = N - 1;
        while (min < max) {
            int sum = arr[min] + arr[max];
            if (sum == x) {  // 값을 찾으면 포인터가 양쪽에서 동시 이동
                count++;
                min++;
                max--;
            }
            if (sum < x) { // 찾는 값보다 작으면 더 큰 값이 필요하기에 오른쪽으로 이동
                min++;
            }
            if (sum > x) { // 찾는 값보다 크면 더 작은 값이 필요하기에 왼쪽으로 이동
                max--;
            }
        }
        // 출력
        System.out.println(count);
    }
}

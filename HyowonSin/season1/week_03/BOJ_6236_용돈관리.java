package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6236_용돈관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] costs = new int[N];

        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int right = 1000000000;

        while (left <= right) {
            // mid 가 K
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 1;

            for (int i = 0; i < N; i++) {
                // 첫 날은 sum 이 0
                // costs[i] 를 더해서 가진 돈 보다 크면 더할 수 없으니
                // count 를 늘리고 sum 을 그 날 금액으로 초기화
                if (sum + costs[i] > mid) {
                    count++;
                    // count 가 M 보다 크면 더 이상 계산할 필요 없으니 break
                    if (count > M) {
                        break;
                    }
                    sum = costs[i];
                } else {
                    sum += costs[i];
                }
            }

            if (sum > mid) {
                left = mid + 1;
            } else if (count > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
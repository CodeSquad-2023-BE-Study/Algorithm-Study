package Week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1000000000;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            long sum = 0;
            for (int i=0; i<N; i++) {
                if (trees[i] > mid) {
                    sum += trees[i] - mid;
                }
            }

            if (sum > M) {
                left = mid + 1;
            } else if (sum < M) {
                right = mid - 1;
            } else {
                System.out.println(mid);
                return;
            }
        }
        System.out.println(right);
    }
}
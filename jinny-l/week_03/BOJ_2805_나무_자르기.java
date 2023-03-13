package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 한번 더 풀어보기
public class BOJ_2805_나무_자르기 {

    private static int max;
    private static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력받으면서 최대 높이의 나무 찾기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Integer.max(max, trees[i]);
        }

        //이분 탐색
        System.out.println(binarySearch(M));
    }

    private static long binarySearch(long M) {
        int min = 0;
        long result = 0;
        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for (long tree : trees) {
                if (tree - mid > 0) {
                    sum += tree - mid;
                }
            }
            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min - 1;
    }
}

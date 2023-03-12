package Week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 시간 초과, 이분탐색으로 풀이 필요
public class BOJ_2805_나무_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        int height = trees[trees.length - 1] - 1;
        while (true) {
            int sum = 0;
            for (int tree : trees) {
                if (tree > height) {
                    sum += tree - height;
                }
            }
            if (sum >= M) {
                System.out.println(height);
                break;
            }
            height--;
        }
    }

    private static void binarySearch() {

    }
}

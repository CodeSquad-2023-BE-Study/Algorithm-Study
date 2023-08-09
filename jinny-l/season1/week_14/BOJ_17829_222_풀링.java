package season1.week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 한번 더 풀어보기
public class BOJ_17829_222_풀링 {

    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 행렬 입력
        matrix = new int[N][N];
        for (int i = 0; i < matrix.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve(0, 0, N));
    }

    private static int solve(int x, int y, int size) {
        if (size == 2) {
            int[] tmp = new int[4];
            int index = 0;
            for (int i = x; i < x + 2; i++) {
                for (int j = y; j < y + 2; j++) {
                    tmp[index] = matrix[i][j];
                    index++;
                }
            }
            Arrays.sort(tmp);
            return tmp[2];
        }

        int[] tmp = new int[4];
        int newSize = size / 2;

        tmp[0] = solve(x, y + newSize, newSize); // 1사분면
        tmp[1] = solve(x, y, newSize);              // 2사분면
        tmp[2] = solve(x + newSize, y, newSize); // 3사분면
        tmp[3] = solve(x + newSize, y + newSize, newSize); // 4사분면

        Arrays.sort(tmp);
        return tmp[2];
    }

}

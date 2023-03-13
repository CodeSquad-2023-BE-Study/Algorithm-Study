package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051_숫자_정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] square = new int[N][M];

        for (int i = 0; i < N; i++) {
            String oneLine = br.readLine();
            for (int j = 0; j < M; j++) {
                square[i][j] = Character.getNumericValue(oneLine.charAt(j));
            }
        }

        int len = Math.min(N, M);

        loop:
        while (len > 1) {
            int row = N - len;
            int col = M - len;
            for (int i = 0; i <= row; i++) {
                for (int j = 0; j <= col; j++) {
                    int vertex = square[i][j];
                    if (vertex == square[i][j + len - 1] && vertex == square[i + len - 1][j]
                            && vertex == square[i + len - 1][j + len - 1]) {
                        break loop;
                    }
                }
            }
            len--;
        }
        System.out.println(len * len);
    }
}

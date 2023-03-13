package week_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 풀이 방법:
 * 1. 체스판을 boolean 2차원 배열로 입력
 * 2. 8*8 체스판을 순회하며 칠해야 할 체스판 개수 계산 - countOf 메서드 참고
 * 3. 최소값 찾기
 */
public class BOJ_1018_체스판_다시_칠하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] chess = new boolean[N][M]; // 입력값을 저장할 배열
        boolean W = true;
        boolean B = false;

        // 체스판 입력받기
        for (int i = 0; i < N; i++) {
            String oneLine = br.readLine();

            for (int j = 0; j < M; j++) {
                if (oneLine.charAt(j) == 'W') {
                    chess[i][j] = W;
                }
                if (oneLine.charAt(j) == 'B') {
                    chess[i][j] = B;
                }
            }
        }

        int count = 64;
        int row = N - 7; // 8칸씩 한꺼번에 움직이기 때문에, 입력 값에 따라 움직일 수 있는 경우의 수
        int col = M - 7;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = countOf(chess, i, j);
                if (tmp < count) { // 최소값 찾기
                    count = tmp;
                }
            }
        }
        System.out.println(count);
    }

    // 체스판에서 칠해야 하는 개수 계산
    public static int countOf(boolean[][] chess, int x, int y) {
        int count = 0;
        int endX = x + 7;
        int endY = y + 7;
        boolean correctColor = chess[x][y];

        for (int i = x; i <= endX; i++) {
            for (int j = y; j <= endY; j++) {
                if (chess[i][j] != correctColor) {
                    count++;
                }
                correctColor = (!correctColor); // 다음 칸 색상으로 변경
            }
            correctColor = (!correctColor); // 줄 바뀌면 색상 한번 더 변경
        }
        return Math.min(count, 64 - count); // chess[x][y] 색상으로 할 때 기준과, 그 반대 기준
    }
}

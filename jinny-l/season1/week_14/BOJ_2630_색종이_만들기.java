package season1.week_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이_만들기 {

    private static int[][] papers;
    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 색종이 입력
        papers = new int[N][N];
        for (int i = 0; i < papers.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < papers.length; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.print(blue);
    }

    private static void divide(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            if (papers[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        // 사각형 내 색상이 일치하지 않을 때
        int newSize = size / 2;
        divide(x, y + newSize, newSize); // 1사분면
        divide(x, y, newSize); // 2사분면
        divide(x + newSize, y, newSize); // 3사분면
        divide(x + newSize, y + newSize, newSize); // 4사분면
    }

    // 사각형 내 종이가 모두 같은 색상인지 판단한다
    private static boolean isSameColor(int x, int y, int size) {
        int color = papers[x][y]; // 기준 색상

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (papers[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}

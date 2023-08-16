package HyowonSin.Week_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] boardAll = new String[N];

        for (int i=0; i<N; i++) {
            boardAll[i] = br.readLine();
        }

        int[][] boardCount = new int[N][M];

        for (int i=0; i<N; i+=2) {
            for (int j=0; j<M; j+=2) {
                if (boardAll[i].charAt(j) != 'W') {
                    boardCount[i][j] = 1;
                } else {
                    boardCount[i][j] = 0;
                }
            }
            for (int j=1; j<M; j+=2) {
                if (boardAll[i].charAt(j) != 'B') {
                    boardCount[i][j] = 1;
                } else {
                    boardCount[i][j] = 0;
                }
            }
        }
        for (int i=1; i<N; i+=2) {
            for (int j=0; j<M; j+=2) {
                if (boardAll[i].charAt(j) != 'B') {
                    boardCount[i][j] = 1;
                } else {
                    boardCount[i][j] = 0;
                }
            }
            for (int j=1; j<M; j+=2) {
                if (boardAll[i].charAt(j) != 'W') {
                    boardCount[i][j] = 1;
                } else {
                    boardCount[i][j] = 0;
                }
            }
        }

        int minCount = 32;

        for (int i=0; i<N-7; i++) {
            for (int j=0; j<M-7; j++) {
                int count = checkBoard(boardCount, i, j);
                if (count > 32) {
                    count = 64 - count;
                }
                if (count < minCount) {
                    minCount = count;
                }
            }
        }
        System.out.println(minCount);
    }

    public static int checkBoard(int[][] boardCount, int x, int y) {
        int count = 0;
        for (int i=x; i<x+8; i++) {
            for (int j=y; j<y+8; j++) {
                count += boardCount[i][j];
            }
        }
        return count;
    }
}
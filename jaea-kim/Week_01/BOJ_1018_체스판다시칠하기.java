package Week_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ_1018_체스판다시칠하기 {
    public static int checkBlack(char[][] b) {//시작이 블랙 -> 짝수가 블랙
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            if (i % 2 == 0) {//짝수 블랙 홀수 화이트
                for (int j = 0; j < b[i].length; j++) {
                    if (j % 2 == 0) {
                        count += (b[i][j] == 'B' ? 0 : 1);
                    } else {
                        count += (b[i][j] == 'W' ? 0 : 1);
                    }
                }
            } else { //짝수 화이트 홀수 블랙
                for (int j = 0; j < b[i].length; j++) {
                    if (j % 2 == 0) {
                        count += (b[i][j] == 'W' ? 0 : 1);
                    } else {
                        count += (b[i][j] == 'B' ? 0 : 1);
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            char[] row = sc.nextLine().toCharArray();
            board[i] = row;
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < m - 7; i++) { //밑으로 내려 확인
            for (int j = 0; j < n - 7; j++) {
                char[][] chessBoard = new char[8][8];
                for (int k = 0; k < 8; k++) {
                    System.arraycopy(board[k + i], j, chessBoard[k], 0, chessBoard[k].length);
                }
                int bCount = checkBlack(chessBoard);
                results.add(bCount);
                results.add(64 - bCount);
            }
        }
        results.sort(Comparator.naturalOrder());
        System.out.println(results.get(0));
    }
}

package HyowonSin.Week_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051_숫자정사각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        
        int min = Math.min(N, M);

        loop:
        for (int i=min; i>0; i--) {
            for (int j=0; j<M-i+1; j++) {
                for (int k=0; k<N-i+1; k++) {
                    if (board[k][j] == board[k][j+i-1] && board[k][j] == board[k+i-1][j] && board[k][j] == board[k+i-1][j+i-1]) {
                        System.out.println(i*i);
                        break loop;
                    }
                }
            }
        }
    }
}

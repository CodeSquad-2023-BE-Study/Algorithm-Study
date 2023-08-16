package season1.week_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403_경로_찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이
        for (int k = 0; k < N; k++) {           // 지나가는 정점
            for (int i = 0; i < N; i++) {       // 시작하는 정점
                for (int j = 0; j < N; j++) {   // 도착하는 정점
                    if (map[i][k] == 1 && map[k][j] == 1) {   // i -> k로 가는 길이 있고, k -> j로 가는 길이 있으면
                        map[i][j] = 1;                        // i -> j로 가는 길이 있다.
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

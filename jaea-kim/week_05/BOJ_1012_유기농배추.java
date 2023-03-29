package week_05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
    static int count = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean[][] map = new boolean[M][N];
            boolean[][] visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                map[v1][v2] = true;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && map[j][k]) {
                        dfs(j, k, map, visited);
                        count++;
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }
    }

    static void dfs(int x, int y, boolean[][] map, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                if (!visited[nx][ny] && map[nx][ny]) {
                    dfs(nx, ny, map, visited);
                }
            }
        }
    }
}

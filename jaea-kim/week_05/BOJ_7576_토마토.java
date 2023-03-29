package week_05;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
    /*
    고민 : 토마토 익은 날을 어떻게 표현해야할지 모르겠다. -> 처음 저장된 큐의 사이즈만큼 반복하고 끝이나면 count++
    1. 익은 토마토 찾기 -> 큐에 넣기
    2. 익은 토마토 주위 4방향 확인 -> 안익었으면 큐에 넣기
    3. 큐에 토마토 없을 때까지 돌려
    4. 안익은 토마토 있는지 확인
        -1 : 있으면
        count - 1 : 없으면
     */

    static int count = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        if (q.size() == M*N) {
            System.out.println(0);
            return;
        }

        bfs(q, map, visited);

        for (int[] row : map) {
            for (int p : row) {
                if (p == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count - 1); //처음 탐색은 당일이니까 -1
    }

    static void bfs(Queue<Point> q, int[][] map, boolean[][] visited) {
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                Point p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                        if (!visited[nx][ny] && map[nx][ny] == 0) {
                            map[nx][ny] = 1;
                            q.add(new Point(nx, ny));
                        }
                        visited[nx][ny] = true;
                    }
                }
            }
            count++;
        }
    }

}
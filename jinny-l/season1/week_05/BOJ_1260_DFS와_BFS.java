package season1.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와_BFS {

    private static int[][] matrix;
    private static boolean[] visited;
    private static int N;
    private static int edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력
        N = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        // 배열 초기화
        visited = new boolean[N + 1];
        matrix = new int[N + 1][N + 1];

        //정점 입력
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        DFS(start);

        Arrays.fill(visited, false); // BFS에서 재사용을 위해 false로 초기화
        System.out.println();

        BFS(start);
    }

    private static void DFS(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 1; i < N + 1; i++) {
            if (matrix[start][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            for (int i = 1; i < N + 1; i++) {
                if (matrix[temp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

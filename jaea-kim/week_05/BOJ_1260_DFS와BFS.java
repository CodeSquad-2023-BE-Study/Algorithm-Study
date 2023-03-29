package week_05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        boolean[][] vertex = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            vertex[v1][v2] = true;
            vertex[v2][v1] = true;
        }

        boolean[] visited = new boolean[N + 1];
        dfs(start, vertex, visited);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(start, vertex, visited);
    }

    public static void dfs(int start, boolean[][] vertex, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i < vertex.length; i++) {
            if (!visited[i] && vertex[start][i]) {
                dfs(i, vertex, visited);
            }
        }
    }

    public static void bfs(int start, boolean[][] vertex, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        System.out.print(start + " ");

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int i = 1; i < vertex.length; i++) {
                if (!visited[i] && vertex[x][i]) {
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}

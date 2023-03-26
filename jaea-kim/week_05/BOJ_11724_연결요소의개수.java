package week_05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertixNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[vertixNum + 1][vertixNum + 1];
        boolean[] visited = new boolean[vertixNum + 1];

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            map[v1][v2] = true;
            map[v2][v1] = true;
        }

        for (int i = 1; i < vertixNum + 1; i++) {
            if (!visited[i]) {
                dfs(i, map, visited);
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int start, boolean[][] map, boolean[] visited) {
        visited[start] = true;

        for (int i = 1; i < map.length; i++) {
            if (!visited[i] && map[start][i]) {
                dfs(i, map, visited);
            }
        }
    }

}

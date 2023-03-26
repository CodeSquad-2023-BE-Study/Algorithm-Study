package week_05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());
        boolean[][] vertex = new boolean[computerNum + 1][computerNum + 1];

        StringTokenizer st;
        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            vertex[v1][v2] = true;
            vertex[v2][v1] = true;
        }

        boolean[] visited = new boolean[computerNum + 1];
        dfs(1, vertex, visited);
        System.out.println(count);
    }
    public static void dfs(int start, boolean[][] vertex, boolean[] visited) {
        visited[start] = true;

        for (int i = 1; i < vertex.length; i++) {
            if (!visited[i] && vertex[start][i]) {
                count++;
                dfs(i, vertex, visited);
            }
        }
    }
}

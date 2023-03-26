import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        int v = Integer.parseInt(stringTokenizer.nextToken());

        boolean[][] map = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }

        List<Integer> dfsResult = new ArrayList<>();
        List<Integer> bfsResult = new ArrayList<>();
        dfs(v, visited, map, dfsResult);
        System.out.println(dfsResult.stream().map(e -> String.valueOf(e)).reduce((a, b) -> a + " " + b).get());
        visited = new boolean[n + 1];
        bfs(v, visited, map, bfsResult);
        System.out.print(bfsResult.stream().map(e -> String.valueOf(e)).reduce((a, b) -> a + " " + b).get());
    }

    public static void dfs(int v, boolean[] visited, boolean[][] map, List<Integer> dfsResult) {
        visited[v] = true;
        dfsResult.add(v);
        for (int i = 1; i <= n; i++) {
            if (map[v][i] && !visited[i])
                dfs(i, visited, map, dfsResult);
        }
    }

    public static void bfs(int v, boolean[] visited, boolean[][] map, List<Integer> bfsResult) {
        visited[v] = true;
        bfsResult.add(v);
        Queue<Integer> queue = new LinkedList();
        queue.offer(v);

        while (!queue.isEmpty()) {
            int nodeIndex = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (map[nodeIndex][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    bfsResult.add(i);
                }
            }
        }
    }
}

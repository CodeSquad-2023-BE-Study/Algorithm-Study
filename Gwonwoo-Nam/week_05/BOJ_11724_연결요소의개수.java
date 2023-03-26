import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_11724_연결요소의개수 {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        boolean[] visited = new boolean[n + 1];
        boolean[][] map = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            map[b][a] = true;
        }


        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i] && map[i][j]) { //간선이 존재하고 방문 안한 상태
                    count++;
                    dfs(i, visited, map);
                }
            }
        }
        for (int i=1;i<=n;i++) {
            if (!visited[i]) {
                count += 1;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int v, boolean[] visited, boolean[][] map) {
        visited[v] = true;
        for (int i = 1; i <= n; i++) {
            if (map[v][i] && !visited[i]) {
                dfs(i, visited, map);
            }
        }

    }

}

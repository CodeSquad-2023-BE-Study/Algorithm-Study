import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {

    public static int m;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testNo = 0; testNo < t;testNo++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            m = Integer.parseInt(stringTokenizer.nextToken()); //가로
            n = Integer.parseInt(stringTokenizer.nextToken()); //세로
            int k = Integer.parseInt(stringTokenizer.nextToken());

            boolean[][] visited = new boolean[100][100];
            boolean[][] map = new boolean[100][100];

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = true;
            }
            int count = 0;
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (map[x][y] && !visited[x][y]) {
                        count++;
                        dfs(x, y, map, visited);
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y, boolean[][] map, boolean[][] visited) {
        visited[x][y] = true;
        if (x + 1 < m && !visited[x + 1][y] && map[x+1][y]) {
            dfs(x + 1, y, map, visited);
        }
        if (y + 1 < n && !visited[x][y + 1] && map[x][y+1]) {
            dfs(x, y + 1, map, visited);
        }
        if (x - 1 >= 0 && !visited[x - 1][y] && map[x-1][y]) {
            dfs(x - 1, y, map, visited);
        }
        if (y - 1 >= 0 && !visited[x][y - 1] && map[x][y-1]) {
            dfs(x, y - 1, map, visited);
        }
    }

}

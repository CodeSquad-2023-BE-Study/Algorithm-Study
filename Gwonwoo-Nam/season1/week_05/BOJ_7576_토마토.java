import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[m + 1][n + 1];
        boolean[][] visited = new boolean[m + 1][n + 1];

        for (int j = 1; j <= n; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        System.out.println(bfs(map,visited));



    }

    public static int bfs(int[][] map, boolean[][] visited) {
        class Location {
            public Location(int x, int y, int date) {
                this.x = x;
                this.y = y;
                this.date = date;
            }

            int x;
            int y;
            int date;
        }
        Queue<Location> queue = new LinkedList();
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (map[i][j] == 1) {
                    queue.offer(new Location(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        int maxDate = 0;
        while(!queue.isEmpty()) {
            Location loc = queue.poll();
            if (loc.x - 1 > 0 && !visited[loc.x - 1][loc.y] && map[loc.x - 1][loc.y] == 0) {
                visited[loc.x-1][loc.y] = true;
                queue.offer(new Location(loc.x-1,loc.y,loc.date + 1));
                map[loc.x-1][loc.y] = 1;
            }
            if (loc.x + 1 <= m && !visited[loc.x + 1][loc.y] && map[loc.x + 1][loc.y] == 0) {
                visited[loc.x+1][loc.y] = true;
                queue.offer(new Location(loc.x+1,loc.y, loc.date + 1));
                map[loc.x+1][loc.y] = 1;
            }
            if (loc.y - 1 > 0 && !visited[loc.x][loc.y-1] && map[loc.x][loc.y-1] == 0) {
                visited[loc.x][loc.y-1] = true;
                queue.offer(new Location(loc.x,loc.y-1,loc.date + 1));
                map[loc.x][loc.y-1] = 1;
            }
            if (loc.y + 1 <= n && !visited[loc.x][loc.y+1] && map[loc.x][loc.y+1] == 0) {
                visited[loc.x][loc.y+1] = true;
                queue.offer(new Location(loc.x,loc.y+1,loc.date + 1));
                map[loc.x][loc.y+1] = 1;
            }
            maxDate = Math.max(maxDate, loc.date);
        }
        return maxDate;

    }

}

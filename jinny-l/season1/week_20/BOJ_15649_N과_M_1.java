package season1.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과_M_1 {

    private static boolean[] visited;
    private static int[] tmp;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 개수 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 풀이
        visited = new boolean[n];
        tmp = new int[m];
        sb = new StringBuilder();

        dfs(n, m, 0);
        System.out.print(sb);
    }

    private static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int i = 0; i < tmp.length; i++) {
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[depth] = i + 1;
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }
}

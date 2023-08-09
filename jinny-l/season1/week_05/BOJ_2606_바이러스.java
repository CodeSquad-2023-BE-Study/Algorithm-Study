package season1.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {

    private static int vertexAmount;
    private static boolean[] isVisited;
    private static int[][] matrix;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점 수, 간선 입력
        vertexAmount = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        // 배열 초기화, 인덱스 번호와 정점 숫자를 맞추기 위해 +1
        isVisited = new boolean[vertexAmount + 1];
        matrix = new int[vertexAmount + 1][vertexAmount + 1];

        // 정점 입력
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }

        // 탐색 및 출력
        dfs(1);
        System.out.println(count);
    }

    private static void dfs(int start) {
        isVisited[start] = true;

        for (int i = 1; i < vertexAmount + 1; i++) {
            if (matrix[start][i] == 1 && !isVisited[i]) {
                count++;
                dfs(i);
            }
        }
    }
}

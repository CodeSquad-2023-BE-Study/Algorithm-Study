package week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724_연결_요소의_개수 {

    private static int[][] matrix;
    private static boolean[] visited;
    private static int vertexAmount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력
        vertexAmount = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        // 배열 초기화
        visited = new boolean[vertexAmount + 1];
        matrix = new int[vertexAmount + 1][vertexAmount + 1];

        //정점 입력
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        int count = 0; // 연결 요소 개수

        // 방문하지 않은 정점을 체크하고, 해당 정점을 기준으로 다시 탐색 시작하며 count를 1개 증가시킨다.
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void DFS(int start) {
        visited[start] = true;
        for (int i = 1; i < vertexAmount + 1; i++) {
            if (matrix[start][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

}

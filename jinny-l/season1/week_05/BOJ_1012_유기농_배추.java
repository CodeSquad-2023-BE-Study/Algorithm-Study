package season1.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 좌표 기준을 어디에 잡느냐에 따라 달리지고, 문제를 풀면서 좌표랑 인덱스랑 헷갈리는 것 같다.
 */
public class BOJ_1012_유기농_배추 {

    private static final int[] dx = {0, 0, 1, -1}; // dx, dy 인덱스로 좌표를 묶으면 상하좌우가 된다.
    private static final int[] dy = {1, -1, 0, 0};

    private static int column;
    private static int row;
    private static int cabbageAmount;
    private static int[][] matrix;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 입력
        int testCaseAmount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseAmount; i++) { // 테케만큼 반복
            // 배추밭의 가로길이, 세로길이, 배추 개수 입력
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            column = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            cabbageAmount = Integer.parseInt(st.nextToken());

            // 배열 초기화
            isVisited = new boolean[row][column];
            matrix = new int[row][column];

            //정점 입력
            for (int j = 0; j < cabbageAmount; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[y][x] = 1; // 여기서 반대로 넣어줬기 때문에 탐색할 때는 순서에 맡게 진행하면 됨
            }

            int count = 0; // 배추흰지렁이 수

            // 배추밭 한칸씩 탐색
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < column; y++) {
                    if (matrix[x][y] == 1 && !isVisited[x][y]) { // 배추가 있고 방문하지 않았으면 dfs 탐색하고 count +1;
                        DFS(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    // DFS 알고리즘
    private static void DFS(int x, int y) {
        isVisited[x][y] = true;

        for (int i = 0; i < dx.length; i++) { // 배추의 상하좌우 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < row && ny >= 0 && ny < column) { // 상하좌우 좌표가 배추밭 범위 안에 있는지 체크
                if (matrix[nx][ny] == 1 && !isVisited[nx][ny]) { // DFS 탐색 조건
                    DFS(nx, ny);
                }
            }
        }
    }
}

package season1.week_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5212_지구_온난화 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        char[][] map = new char[row][column];
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 지도 출력 범위
        int minRow = 10;
        int minColumn = 10;

        int maxRow = 0;
        int maxColumn = 0;

        // 섬 주위 3면 이상이 바다인지 체크
        char[][] newMap = new char[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                if (map[i][j] == 'X') { // 땅인 경우 4방향 탐색
                    int sea = 0;

                    for (int k = 0; k < 4; k++) {
                        int x = dx[k] + i;
                        int y = dy[k] + j;

                        // 지도 범위를 벗어났는지 확인, 벗어나면 바다
                        if (x < 0 || y < 0 || x >= row || y >= column || map[x][y] == '.') {
                            sea++;
                        }
                    }

                    if (sea < 3) { // 땅 주위 3면 이하가 바다면 땅 -> 땅 유지
                        newMap[i][j] = 'X';

                        // 섬을 포함한 최소 크기의 지도를 출력하기 위해 지도 범위 변경
                        minRow = Math.min(minRow, i);
                        minColumn = Math.min(minColumn, j);

                        maxRow = Math.max(maxRow, i);
                        maxColumn = Math.max(maxColumn, j);
                    } else {
                        newMap[i][j] = '.';
                    }
                } else { // 바다면 바다 값 넣어주기
                    newMap[i][j] = '.';
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minColumn; j <= maxColumn; j++) {
                sb.append(newMap[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

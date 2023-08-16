package season1.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913_달팽이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 바같에서 안으로 도는 방향 순서대로 설정
        int[] dx = {1, 0, -1, 0}; // 하우상좌
        int[] dy = {0, 1, 0, -1};

        // 입력
        int N = Integer.parseInt(br.readLine());
        int location = Integer.parseInt(br.readLine());

        // 출력할 좌표
        int[][] result = new int[N][N];
        // 시작 숫자
        result[0][0] = N * N;
        // 시작 좌표
        int currentX = 0;
        int currentY = 0;
        // 시작할 방향 인덱스
        int index = 0;
        // 찾아야할 좌표
        int findX = 0;
        int findY = 0;

        while (index < 4) {
            int nx = currentX + dx[index];
            int ny = currentY + dy[index];

            // 좌표가 범위 안에 있고, 아직 탐색하지 않은 경우
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && result[nx][ny] == 0) {

                // 이전 좌표 보다 1 작은 숫자를 넣어준다.
                int number = result[currentX][currentY] - 1;
                result[nx][ny] = number;

                // 값이 찾아야 할 값과 일치하면 좌표 저장
                if (number == location) {
                    findX = nx;
                    findY = ny;
                }

                // 값이 1이 되면 종료
                if (number == 1) {
                    break;
                }

                // 좌표 갱신
                currentX = nx;
                currentY = ny;

            } else {
                // 좌표가 범위를 벗어났거나 이미 탐색한 경우, 방향을 바꾼다
                index++;
            }

            // 방향을 다 돌면 초기화한다
            if (index == 4) {
                index = 0;
            }
        }

        // 달팽이 숫자 StringBuilder에 저장
        for (int[] oneLine : result) {
            for (int i = 0; i < N; i++) {
                sb.append(oneLine[i]).append(" ");
            }
            sb.append("\n");
        }

        // 좌표 저장
        sb.append(findX + 1).append(" ").append(findY + 1); // 좌표 = 인덱스 + 1

        // 출력
        System.out.println(sb);
    }
}

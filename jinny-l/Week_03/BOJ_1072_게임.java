package Week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 시간 초과, 이분탐색으로 풀이 필요
public class BOJ_1072_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        double x = Integer.parseInt(st.nextToken());
        double y = Integer.parseInt(st.nextToken());

        // Z가 절대 변하지 않을 때
        if (x == y) {
            System.out.println(-1);
            return;
        }

        // 최소 게임 횟수 계산
        int winRate = (int) (y * 100 / x);
        int count = 0;
        while (true) {
            x++; // 게임 횟수 증가
            y++; // 승률이 100퍼센트여서 이긴 게임도 증가
            count++;
            int changedWinRate = (int) (y * 100 / x);
            if (changedWinRate > winRate) {
                break;
            }
            if (x == 1_000_000_000 && changedWinRate == winRate) { // Z가 절대 변하지 않을 때
                count = -1;
                break;
            }
        }
        System.out.println(count);
    }
}

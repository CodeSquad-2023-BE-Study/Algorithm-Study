package week_08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_구간구하기 {
    /*
     * 힌트 : (1,1) 부터 합을 표시
     * (1,1) ~ (x2, y2) 넓이 - (1,1) ~ (x1 -1, y2) 넓이 - (1,1) ~ (x2, y1 - 1)의 넓이 + (1,1) ~ (x1 - 1, y1 - 1)의 넓이
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //표의 길이
        int M = Integer.parseInt(st.nextToken()); //합의 횟수

        int[][] map = new int[N][N];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] target = new int[M][4];
        for (int i = 0; i < target.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                target[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //넓이 계산
        int[][] area = new int[N][N];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        area[i][j] = map[i][j];
                    } else {
                        area[i][j] = area[i][j - 1] + map[i][j];
                    }
                } else if (j == 0) {
                    area[i][j] = area[i - 1][j] + map[i][j];
                } else {
                    area[i][j] = area[i - 1][j] + area[i][j - 1] - area[i - 1][j - 1] + map[i][j];
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int x1 = target[i][0] -1;
            int y1 = target[i][1] -1;
            int x2 = target[i][2] -1;
            int y2 = target[i][3] -1;


            if (x1 == 0 && y1 == 0) {
                System.out.println(area[x2][y2]);
            } else if (x1 == 0) {
                System.out.println(area[x2][y2] - area[x2][y1 -1]);
            } else if (y1 == 0) {
                System.out.println(area[x2][y2] - area[x1 -1][y2]);
            } else {
                System.out.println(area[x2][y2] - area[x1 -1][y2] - area[x2][y1 -1] + area[x1 -1][y1 -1]);
            }
        }


    }
}

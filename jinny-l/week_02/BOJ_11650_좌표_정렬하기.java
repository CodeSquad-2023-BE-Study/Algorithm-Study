package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11650_좌표_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 입력
        Point[] points = new Point[N];
        for (int i = 0; i < points.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 정렬
        Arrays.sort(points, (o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });

        // 출력
        StringBuilder sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point)
                    .append("\n");
        }
        System.out.println(sb);
    }

    // 좌표 객체
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}

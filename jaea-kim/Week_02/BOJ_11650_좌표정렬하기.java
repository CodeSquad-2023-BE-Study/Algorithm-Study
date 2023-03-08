package Week_02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_11650_좌표정렬하기 {
    static class Point {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();

        Point[] points = new Point[num];

        for (int i = 0; i < num; i++) {
            String[] input = sc.nextLine().split(" ");
            points[i] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.x, o2.x) == 0 ? Integer.compare(o1.y, o2.y) : Integer.compare(o1.x, o2.x);
            }
        });

        for (Point point : points) {
            System.out.println(point.toString());
        }
    }
}

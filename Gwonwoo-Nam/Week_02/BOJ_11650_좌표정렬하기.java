
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_11650_좌표정렬하기 {
    static class Point implements Comparable {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Point target = (Point) o;
            if (this.x > target.x) {
                return 1;
            }
            else if (this.x == target.x) {
                return (this.y > target.y ? 1 : -1);
            }
            return -1;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] loc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            points.add(new Point(loc[0], loc[1]));
        }

        points.sort(Point::compareTo);
        for (Point p : points) {
            System.out.println(p.toString());
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2805_나무자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = xy[0];
        int m = xy[1];

        long[] trees = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long low = 0;
        long high = Long.MAX_VALUE;
        long mid;

        while (low + 1 < high) {
            mid = (low + high) / 2;
            //절단한 나무 길이의 총합이 m보다 높은 경우 -> 절단 높이를 높인다.
            if (check(mid, trees) >= m) {
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.println(low);
    }
    public static long check(long mid, long[] trees) {
        long total = 0;
        for (long tree : trees) {
            if (tree > mid) {
                total += tree - mid;
            }
        }
        return total;
    }
}

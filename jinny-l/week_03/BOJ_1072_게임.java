package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 나중에 한번 더 풀어보기
public class BOJ_1072_게임 {

    private static int winRate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //입력
        double x = Integer.parseInt(st.nextToken());
        double y = Integer.parseInt(st.nextToken());

        winRate = getRate(x, y); // 조건
        System.out.println(binarySearch(x, y));
    }

    private static long binarySearch(double x, double y) {
        long left = 0;
        long right = 1_000_000_000;
        long count = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            if ((getRate(x + mid, y + mid)) == winRate) {
                left = mid + 1;
            } else {
                count = mid;
                right = mid - 1;
            }
        }
        return count;
    }

    private static int getRate(double x, double y) {
        return (int) (y * 100 / x);
    }
}

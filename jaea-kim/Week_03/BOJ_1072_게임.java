package Week_03;

import java.util.Scanner;

public class BOJ_1072_게임 {
    /*
    기준 : 추가 횟수
    추가 횟수는 1 ~ 1,000,000,000
     */
    public static long getProbability(long winNum, long gameNum) {
        long w = (long) winNum * 100;
        return w / gameNum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long y = scanner.nextLong();

        long target = getProbability(y, x);

        int low = 1;
        int high = 1000000000;
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long probability = getProbability(y + mid, x + mid);

            if (probability == target) {
                low = mid + 1;
            } else if (probability > target) {
                answer = mid;
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

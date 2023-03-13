package week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

// TODO: 1번 더 풀어보기
public class BOJ_6236_용돈_관리 {

    private static int M;
    private static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력받으면서 max 값 찾고 sum 구하기
        // max 값은 이분탐색할 때 왼쪽 끝 값이 되고, sum은 오른쪽 끝값이 된다.

        /* max 값을 찾는 이유:
         * 1. max 값을 인출해야 최소 N번의 인출을 만족할 수 있기 때문
         * 2. max 값보다 작게 설정하면 max값이 순서가 왔을 때 사용할 수 없음
         */
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        money = new int[N];
        int max = 0;
        for (int i = 0; i < money.length; i++) {
            money[i] = Integer.parseInt(br.readLine());
            max = Integer.max(money[i], max);
        }
        int sum = IntStream.of(money).sum();

        System.out.println(binarySearchMoney(max, sum));

    }

    // 이분 탐색 구현
    private static int binarySearchMoney(int left, int right) {
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getWithdrawalCount(mid) > M) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }

    // 이분탐색 시 사용될 조건: 인출 횟수
    private static int getWithdrawalCount(int withdrawalAmount) {
        int count = 1;
        int balance = withdrawalAmount;
        for (int dailyMoney : money) {
            balance -= dailyMoney;
            if (balance < 0) {
                count++;
                balance = withdrawalAmount - dailyMoney;
            }
        }
        return count;
    }
}

package Week_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6236_용돈관리 {
    public static int getWithdrawalsNum(int money, int[] useMoney) { //인출횟수 구하기
        int count = 1;
        int haveMoney = money;

        for (int j : useMoney) {
            if (haveMoney >= j) {
                haveMoney -= j;
            } else {
                count++;
                haveMoney = money - j;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] useMoney = new int[n];

        for (int i = 0; i < n; i++) {
            useMoney[i] = Integer.parseInt(br.readLine());
        }

        int totalMoney = Arrays.stream(useMoney).reduce(0, Integer::sum); //총 사용 금액보다 많이는 필요 없으니
        int low = Arrays.stream(useMoney).max().getAsInt(); //사용할 용돈 중 가장 큰 금액 이상은 가지고 있어야함
        int high = totalMoney;
        int answer = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (getWithdrawalsNum(mid, useMoney) <= m) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(answer);
    }
}

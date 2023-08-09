import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_6236_용돈관리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = xy[0];
        int m = xy[1];
        List<Integer> integerList = new ArrayList<>();
        for (int i=0;i<n;i++) {
            integerList.add(Integer.parseInt(br.readLine()));
        }

        int high = Integer.MAX_VALUE;
        int low = 0;
        int mid;
        while (low + 1< high) {
            mid = (low + high)/2;
            //인출 횟수가 같거나 적으면 금액을 낮춘다.
            if (check(mid, integerList) <= m) {
                high = mid;

            } else {
                //인출 횟수가 많으면 금액을 높인다.
                low = mid;
            }
        }
        System.out.println(high);
    }

    public static int check(int mid, List<Integer> integerList) {
        int count = 1;
        int money = mid;
        for (int e : integerList) {
            if (mid < e) {
                return Integer.MAX_VALUE;//최소 금액에 도달하지 못하면 금액을 높인다.
            }
            if (money >= e) {
                money -= e;
            }
            else {
                count++;
                money = mid;
                money -= e;
            }
        }
        return count;
    }

}
